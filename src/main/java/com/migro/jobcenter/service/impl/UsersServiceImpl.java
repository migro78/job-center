package com.migro.jobcenter.service.impl;

import com.migro.jobcenter.mapper.UsersMapper;
import com.migro.jobcenter.model.Users;
import com.migro.jobcenter.service.IUsersService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.doublewin.core.base.BaseService;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.SecurityUtil;
import top.doublewin.core.util.WebUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author migro
 * @since 2020-04-27
 */
@Service(interfaceClass = IUsersService.class)
@Component
public class UsersServiceImpl extends BaseService<Users, UsersMapper> implements IUsersService {

    @Override
    public boolean login(String username, String password) {
        if(DataUtil.isEmpty(username) || DataUtil.isEmpty(password)){
            return false;
        }
        // 构造参数
        Users param = new Users();
        param.setUsername(username);
        // 根据username查询用户信息
        Users user = selectOne(param);
        if(DataUtil.isEmpty(user)){
            return false;
        }
        logger.debug("login password compare: {} to {}",user.getPassword(),SecurityUtil.encryptPassword(password));
        // 比对用户密码
        if(!user.getPassword().equals(SecurityUtil.encryptPassword(password))){
            return false;
        }

        return true;
    }
}
