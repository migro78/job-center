package com.migro.jobcenter.client;

/**
 * <p>
 * 全局变量类
 * </p>
 *
 * @author migro
 * @since 2020/11/13 10:33
 */
public class GlobalParams {
    private static String host;
    private static String account;
    private static String secret;
    private static String accessToken;

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        GlobalParams.host = host;
    }

    public static String getAccount() {
        return account;
    }

    public static void setAccount(String account) {
        GlobalParams.account = account;
    }

    public static String getSecret() {
        return secret;
    }

    public static void setSecret(String secret) {
        GlobalParams.secret = secret;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        GlobalParams.accessToken = accessToken;
    }
}
