package com.migro.jobcenter.web;

import com.migro.jobcenter.model.Users;
import com.migro.jobcenter.service.IUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.doublewin.core.base.BaseController;
import top.doublewin.core.exception.BusinessException;
import top.doublewin.core.exception.LoginException;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.SecurityUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/4/21 11:44
 */
@Controller
public class LoginController extends BaseController<Users, IUsersService> {
    @GetMapping("/")
    public String initLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

    @GetMapping("/user/resetPwd")
    public String resetPwdView() {
        return "user/resetPwd";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request, String username, String password) {
        if (!service.login(username, password)) {
            throw new LoginException("用户或密码错误！");
        }
        request.getSession().setAttribute("username", username);
        return super.setSuccessModelMap();
    }

    @PostMapping("/user/resetPwd")
    public Object resetPwd(Long id, String oldPassword, String newPassword) {
        logger.debug("id={},oldPassword={},newPassword={}", id, oldPassword, newPassword);
        Users users = service.queryById(id);
        if (DataUtil.isEmpty(users)) {
            throw new BusinessException("用户不存在！");
        }
        // 验证旧密码
        if (!users.getPassword().equals(SecurityUtil.encryptPassword(oldPassword))) {
            throw new BusinessException("旧密码错误！");
        }
        // 更新新密码
        users.setPassword(SecurityUtil.encryptPassword(newPassword));
        service.update(users);
        return super.setSuccessModelMap();
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request,ModelMap mmap) {
        String username = (String)request.getSession().getAttribute("username");
        if(DataUtil.isEmpty(username)){
            mmap.put("code",800);
            mmap.put("msg","您还未登录！");
            return "error/unauth";
        }
        mmap.put("username",username);
        mmap.put("copyrightYear", 2020);
        mmap.put("demoEnabled", true);
        return "index";
    }

    @GetMapping("/main")
    public String main(ModelMap mmap) {
        mmap.put("version", "1.0");
        return "main";
    }

}
