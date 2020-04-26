package com.migro.jobcenter.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/4/20 15:51
 */
@Component
@ConfigurationProperties(prefix="job")
public class JobProps {
    private String dubboRegistUrl;

    public String getDubboRegistUrl() {
        return dubboRegistUrl;
    }

    public void setDubboRegistUrl(String dubboRegistUrl) {
        this.dubboRegistUrl = dubboRegistUrl;
    }
}
