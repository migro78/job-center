package com.migro.jobcenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/4/21 11:44
 */
@Controller
public class LoginController {
    @GetMapping("/")
    public String initLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(String username, String password) {
        System.out.println("username == " + username + ", password == " + password);
        Map ret = new HashMap();
        ret.put("code", 0);
        return ret;
    }


    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        // SysUser user = ShiroUtils.getSysUser();
        // 根据用户id取出菜单
        //List<SysMenu> menus = menuService.selectMenusByUser(user);
        //mmap.put("menus", menus);
        //mmap.put("user", user);
        //mmap.put("sideTheme", configService.selectConfigByKey("sys.index.sideTheme"));
        // mmap.put("skinName", configService.selectConfigByKey("sys.index.skinName"));
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
