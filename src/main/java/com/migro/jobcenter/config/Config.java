package com.migro.jobcenter.config;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.client.GlobalParams;
import com.migro.jobcenter.model.ClientProps;
import com.migro.jobcenter.model.JobProps;
import com.migro.jobcenter.utils.DubboInvokeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.doublewin.core.config.MybatisPlusConfig;
import top.doublewin.core.config.RedisConfig;
import top.doublewin.core.config.WebConfig;

import javax.annotation.PostConstruct;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/4/21 11:43
 */
@Configuration
@Import({WebConfig.class, MybatisPlusConfig.class, RedisConfig.class})
public class Config {
    protected Logger logger = LogManager.getLogger();
    @Autowired
    JobProps jobProps;
    @Autowired
    ClientProps clientProps;

    @PostConstruct
    public void init() {
        DubboInvokeUtil.registryAddress = jobProps.getDubboRegistUrl();
        logger.debug("==========================>>>>>>>>>>JobProps: {}", JSON.toJSONString(jobProps));
        GlobalParams.setHost(clientProps.getHost());
        GlobalParams.setAccount(clientProps.getAccount());
        GlobalParams.setSecret(clientProps.getSecret());
        logger.debug("==========================>>>>>>>>>>ClientProps: {}", JSON.toJSONString(clientProps));
    }

}
