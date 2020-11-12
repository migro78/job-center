package com.migro.jobcenter.service.impl;

import com.migro.jobcenter.mapper.UsersMapper;
import com.migro.jobcenter.model.Users;
import com.migro.jobcenter.service.IUsersService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Component;
import top.doublewin.core.base.BaseService;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.SecurityUtil;
import top.doublewin.core.util.WebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

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
        if (DataUtil.isEmpty(username) || DataUtil.isEmpty(password)) {
            return false;
        }
        // 构造参数
        Users param = new Users();
        param.setUsername(username);
        // 根据username查询用户信息
        Users user = selectOne(param);
        if (DataUtil.isEmpty(user)) {
            return false;
        }
        logger.debug("login password compare: {} to {}", user.getPassword(), SecurityUtil.encryptPassword(password));
        // 比对用户密码
        if (!user.getPassword().equals(SecurityUtil.encryptPassword(password))) {
            return false;
        }

        return true;
    }

    @Override
    public Object jobTest() {
        logger.debug("jobTest 执行成功.");
        return "SUCCESS";
    }

    @Override
    public Object jobTestWithParam(Map param) {
        logger.debug("jobTestWithParam执行成功，执行参数：{}", param);
        return "SUCCESS," + param;
    }

    @Override
    public CompletableFuture<Map> asyncHello(Map param) {
        RpcContext savedContext = RpcContext.getContext();
        // 建议为supplyAsync提供自定义线程池，避免使用JDK公用线程池
        return CompletableFuture.supplyAsync(() -> {
            logger.debug("RpcContext Attachment:consumer-key1,value is {}", savedContext.getAttachment("consumer-key1"));
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            param.put("result", "SUCCESS");
            logger.debug("asyncHello completed...!");
            return param;
        });
    }
}
