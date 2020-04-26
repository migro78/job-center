package com.migro.jobcenter.core;

import com.migro.jobcenter.utils.DubboInvokeUtil;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.doublewin.core.util.DataUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/4/10 17:15
 */
public class DubboServiceFactory {
    protected Logger logger = LogManager.getLogger();

    private RegistryConfig registry;


    private static class SingletonHolder {
        private static DubboServiceFactory INSTANCE = new DubboServiceFactory();
    }

    private DubboServiceFactory() {
        RegistryConfig registryConfig = new RegistryConfig();
        logger.debug("DubboServiceFactory0001 registryAddress is {}", DubboInvokeUtil.registryAddress);
        if (DataUtil.isEmpty(DubboInvokeUtil.registryAddress)) {
            DubboInvokeUtil.registryAddress = "zookeeper://127.0.0.1:2181";
        }
        logger.debug("DubboServiceFactory0002 registryAddress is {}", DubboInvokeUtil.registryAddress);
        registryConfig.setAddress(DubboInvokeUtil.registryAddress);
        this.registry = registryConfig;
    }

    public static DubboServiceFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Object genericInvoke(String applicationName, String interfaceClass, String methodName, Map parameters) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registry);
        reference.setCheck(false);
        // 接口名
        reference.setInterface(interfaceClass);
        // 声明为泛化接口
        reference.setGeneric(true);

        //ReferenceConfig实例很重，封装了与注册中心的连接以及与提供者的连接，
        //需要缓存，否则重复生成ReferenceConfig可能造成性能问题并且会有内存和连接泄漏。
        //API方式编程时，容易忽略此问题。
        //这里使用dubbo内置的简单缓存工具类进行缓存

        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用

        if (DataUtil.isNotEmpty(parameters)) {
            int len = parameters.size();
            String[] invokeParamTyeps = new String[1];
            Object[] invokeParams = new Object[1];
            invokeParamTyeps[0] = "java.util.Map";
            invokeParams[0] = parameters;
            logger.debug("Dubbo genericInvoke Param: ParamType is {},ParamValue is {}.", invokeParamTyeps[0], invokeParams[0]);

            return genericService.$invoke(methodName, invokeParamTyeps, invokeParams);
        }
        return genericService.$invoke(methodName, null, null);
    }

    public static void main(String[] args) {
        String interfaceClass = "com.doublewin.specialdisease.service.ISysUserService";
        String methodName = "selectSysUserPage";
        List<DubboInvokeParam> param = new ArrayList<>();
        HashMap map = new HashMap();
        //map.put("name", "U");
        System.out.println("====================>>>>>>>>>>>>>" + DubboServiceFactory.getInstance().genericInvoke("special-disease", interfaceClass, methodName, map));


    }
}
