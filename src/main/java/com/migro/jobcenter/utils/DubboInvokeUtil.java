package com.migro.jobcenter.utils;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.core.DubboServiceFactory;
import com.migro.jobcenter.model.SysJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * <p>
 * 执行Dubbo Job任务工具
 * </p>
 *
 * @author migro
 * @since 2020/4/13 15:34
 */
public class DubboInvokeUtil {
    protected static Logger logger = LogManager.getLogger();


    public static String registryAddress;

    /**
     * 执行方法
     *
     * @param sysJob 系统任务
     */
    public static Object invokeMethod(SysJob sysJob) throws Exception {
        String invokeTarget = sysJob.getInvokeTarget();
        String beanName = BeanInvokeUtil.getBeanName(invokeTarget);
        String methodName = BeanInvokeUtil.getMethodName(invokeTarget);
        Map methodParams = getMethodParams(invokeTarget);
        logger.debug("invokeTarget is {},beanName is {},methodName is {},methodParams is {}",invokeTarget,beanName,methodName,methodParams);
        if (!BeanInvokeUtil.isValidClassName(beanName)) {
            throw new RuntimeException("Dubbo服务调用需要完整包名:" + beanName);
        }

        return DubboServiceFactory.getInstance().genericInvoke(sysJob.getApplicationName(),beanName,methodName,methodParams);
    }



    /**
     * 获取method方法参数相关列表
     *
     * @param invokeTarget 目标字符串
     * @return method方法相关参数列表
     */
    public static Map getMethodParams(String invokeTarget) {
        String methodStr = StringUtils.substringBetween(invokeTarget, "(", ")");
        if (StringUtils.isEmpty(methodStr)) {
            return null;
        }
        logger.debug("Dubbo方法参数：{}",methodStr);
        return JSON.parseObject(methodStr);
    }

}
