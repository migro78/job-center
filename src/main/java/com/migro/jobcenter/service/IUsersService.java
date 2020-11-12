package com.migro.jobcenter.service;

import com.migro.jobcenter.model.Users;
import top.doublewin.core.base.IBaseService;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * 用户表  服务类
 * </p>
 *
 * @author migro
 * @since 2020-04-27
 */
public interface IUsersService extends IBaseService<Users> {
    boolean login(String username,String password);

    Object jobTest();

    Object jobTestWithParam(Map param);

    CompletableFuture<Map> asyncHello(Map param);
}