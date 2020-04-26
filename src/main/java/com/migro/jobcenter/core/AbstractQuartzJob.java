package com.migro.jobcenter.core;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.model.SysJob;
import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.service.ISysJobLogService;
import com.migro.jobcenter.utils.ScheduleConstants;
import com.migro.jobcenter.utils.SpringUtils;
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

/**
 * 抽象quartz调用
 *
 * @author ruoyi
 */
public abstract class AbstractQuartzJob implements Job {
    protected static Logger logger = LogManager.getLogger();

    /**
     * 线程本地变量
     */
    private static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysJob sysJob = new SysJob();
        Object param = context.getMergedJobDataMap().get(ScheduleConstants.TASK_PROPERTIES);
        BeanUtils.copyProperties(param,sysJob);
        logger.debug("从Quartz表读取Job任务配置信息：{}",JSON.toJSONString(sysJob));
        try {
            before(context, sysJob);
            if (sysJob != null) {
                doExecute(context, sysJob);
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
        Date startTime = threadLocal.get();
        threadLocal.remove();

        final SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setJobName(sysJob.getJobName());
        sysJobLog.setJobGroup(sysJob.getJobGroup());
        sysJobLog.setInvokeTarget(sysJob.getInvokeTarget());
        sysJobLog.setStartTime(startTime);
        sysJobLog.setStopTime(new Date());
        long runMs = sysJobLog.getStopTime().getTime() - sysJobLog.getStartTime().getTime();
        sysJobLog.setTimeCost(runMs);
        String result = "";
        if (e != null) {
            sysJobLog.setStatus(Constants.FAIL);
            String errorMsg = DataUtil.substring(ExceptionUtil.getStackTraceAsString(e), 0, 2000);
            sysJobLog.setExceptionInfo(errorMsg);
            result = Constants.FAIL_MSG;
        } else {
            sysJobLog.setStatus(Constants.SUCCESS);
            result = Constants.SUCCESS_MSG;
        }
        sysJobLog.setJobMessage(result);

        // 写入数据库当中
        SpringUtils.getBean(ISysJobLogService.class).update(sysJobLog);
    }

    /**
     * 执行方法，由子类重载
     *
     * @param context 工作执行上下文对象
     * @param sysJob  系统计划任务
     * @throws Exception 执行过程中的异常
     */
    protected abstract void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception;
}
