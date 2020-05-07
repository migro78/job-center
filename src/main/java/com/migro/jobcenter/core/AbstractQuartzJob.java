package com.migro.jobcenter.core;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.model.SysJob;
import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.service.ISysJobLogService;
import com.migro.jobcenter.utils.ScheduleConstants;
import com.migro.jobcenter.utils.SpringUtils;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;
import top.doublewin.core.support.context.Constants;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.ExceptionUtil;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 抽象quartz调用
 *
 * @author ruoyi
 */
public abstract class AbstractQuartzJob implements Job {
    protected static Logger logger = LogManager.getLogger();

    /**
     * 线程本地变量-开始时间
     */
    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    /**
     * 线程本地变量-执行结果
     */
    private static ThreadLocal<Object> result = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysJob sysJob = new SysJob();
        Object param = context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES);
        BeanUtils.copyProperties(param, sysJob);
        logger.debug("从Quartz表读取Job任务配置信息：{}", JSON.toJSONString(sysJob));
        try {
            before(context, sysJob);
            if (sysJob != null) {
                result.set(doExecute(context, sysJob));
            }
            after(context, sysJob, null);
        } catch (Exception e) {
            logger.error("任务执行异常  - ：", e);
            after(context, sysJob, e);
        }
    }

    /**
     * 执行前
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     */
    protected void before(JobExecutionContext context, SysJob sysJob) {
        threadLocal.set(new Date());
    }

    /**
     * 执行后
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     */
    protected void after(JobExecutionContext context, SysJob sysJob, Exception e) {

        final SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setJobName(sysJob.getJobName());
        sysJobLog.setJobGroup(sysJob.getJobGroup());
        sysJobLog.setInvokeTarget(sysJob.getInvokeTarget());

        // 调用异步处理过程
        if (DataUtil.isNotEmpty(sysJob.getAsync()) && sysJob.getAsync() == 1) {
            doAsyncAfter(sysJobLog, e);
        } else {
            // 调用同步处理过程
            doSyncAfter(sysJobLog, e);
        }

        // 写入数据库当中
        SpringUtils.getBean(ISysJobLogService.class).update(sysJobLog);
    }

    /**
     * 同步调用后处理
     *
     * @param
     * @return
     */
    private void doSyncAfter(SysJobLog sysJobLog, Exception e) {
        Date startTime = threadLocal.get();
        threadLocal.remove();
        Object res = result.get();
        result.remove();

        sysJobLog.setJobMessage(res == null ? "执行失败" : JSON.toJSONString(res));
        long runMs = System.currentTimeMillis() - startTime.getTime();
        sysJobLog.setTimeCost(runMs);
        if (e != null) {
            sysJobLog.setStatus(Constants.FAIL);
            String errorMsg = DataUtil.substring(ExceptionUtil.getStackTraceAsString(e), 0, 2000);
            sysJobLog.setExceptionInfo(errorMsg);
        } else {
            sysJobLog.setStatus(Constants.SUCCESS);
        }

    }

    /**
     * 异步调用后处理
     *
     * @param
     * @return
     */
    private void doAsyncAfter(SysJobLog sysJobLog, Exception e) {
        Date startTime = threadLocal.get();
        threadLocal.remove();
        // 超时计时器
        long count = 0;
        // 超时时间设置
        long timeOut = 2 * 60 * 1000;
        // 异常信息记录
        String errorMsg = null;
        // 执行结果
        Object res = null;

        if (DataUtil.isEmpty(e)) {
            CompletableFuture<Map> completableFuture = RpcContext.getContext().getCompletableFuture();
            logger.debug("completableFuture 2:{}", completableFuture);
            while (!completableFuture.isDone() && count < timeOut) {
                try {
                    Thread.sleep(1000);
                    count = count + 1000;
                    //logger.debug("count:{},completableFuture.isDone:{}", count, completableFuture.isDone());
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            // 判断超时
            if (count >= timeOut) {
                errorMsg = "异步调用等待超时，等待时长" + count + "ms";
            } else {
                try {
                    // 获取异步调用结果
                    res = completableFuture.get();
                    logger.debug("异步调用结果============>>>>>>>>{}",res);
                } catch (InterruptedException e1) {
                    logger.error("获取异步执行结果异常1", e1);
                    errorMsg = DataUtil.substring(ExceptionUtil.getStackTraceAsString(e1), 0, 2000);
                } catch (ExecutionException e1) {
                    logger.error("获取异步执行结果异常2", e1);
                    errorMsg = DataUtil.substring(ExceptionUtil.getStackTraceAsString(e1), 0, 2000);
                }
            }
            if (DataUtil.isNotEmpty(errorMsg)) {
                sysJobLog.setStatus(Constants.FAIL);
                sysJobLog.setExceptionInfo(errorMsg);
            } else {
                sysJobLog.setStatus(Constants.SUCCESS);
            }
        } else {
            // job 层异常
            sysJobLog.setStatus(Constants.FAIL);
            errorMsg = DataUtil.substring(ExceptionUtil.getStackTraceAsString(e), 0, 2000);
            sysJobLog.setExceptionInfo(errorMsg);
        }

        long runMs = System.currentTimeMillis() - startTime.getTime();
        sysJobLog.setTimeCost(runMs);
        sysJobLog.setJobMessage(res == null ? "执行失败" : JSON.toJSONString(res));
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract Object doExecute(JobExecutionContext context, SysJob sysJob) throws Exception;
}
