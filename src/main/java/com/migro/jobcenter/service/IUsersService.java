package com.migro.jobcenter.service;

import com.migro.jobcenter.model.Users;
import top.doublewin.core.base.IBaseService;

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
}