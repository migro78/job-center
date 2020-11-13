package com.migro.jobcenter.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 客户端配置类
 * </p>
 *
 * @author migro
 * @since 2020/11/13 10:30
 */
@Component
@ConfigurationProperties(prefix="client")
public class ClientProps {
    private String host;
    private String account;
    private String secret;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
