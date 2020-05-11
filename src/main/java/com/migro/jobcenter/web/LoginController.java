package com.migro.jobcenter.web;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.model.Users;
import com.migro.jobcenter.model.vo.MainPageVO;
import com.migro.jobcenter.service.ISysJobLogService;
import com.migro.jobcenter.service.ISysJobService;
import com.migro.jobcenter.service.IUsersService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.doublewin.core.base.BaseController;
import top.doublewin.core.exception.BusinessException;
import top.doublewin.core.exception.LoginException;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.DateUtil;
import top.doublewin.core.util.InstanceUtil;
import top.doublewin.core.util.SecurityUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
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
public class LoginController extends BaseController<Users, IUsersService> {

    @Autowired
    ISysJobService jobService;
    @Autowired
    ISysJobLogService jobLogService;

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
    public String index(HttpServletRequest request, ModelMap mmap) {
        String username = (String) request.getSession().getAttribute("username");
        if (DataUtil.isEmpty(username)) {
            mmap.put("code", 800);
            mmap.put("msg", "您还未登录！");
            return "error/unauth";
        }
        mmap.put("username", username);
        mmap.put("copyrightYear", 2020);
        mmap.put("demoEnabled", true);
        return "index";
    }

    @GetMapping("/main")
    public String main(ModelMap mmap) {
        // 查询统计数据
        Date end = new Date();
        Date start = DateUtil.addDate(end, Calendar.DAY_OF_MONTH, -8);
        String startTime = DateUtil.format(start, "YYYY-MM-dd");
        String endTime = DateUtil.format(end, "YYYY-MM-dd");
        logger.debug("startTime : {} ,, endTime : {}", startTime, endTime);
        Map param = InstanceUtil.newHashMap();
        param.put("startTime", startTime);
        param.put("endTime", endTime);

        // 统计数量
        List<MainPageVO> dayList = jobLogService.dayLogs(param);
        MainPageVO jobCount = jobService.jobCount();
        MainPageVO logsCount = jobLogService.jobLogsCount();

        jobCount.setLogsTotal(logsCount.getLogsTotal());
        jobCount.setLogsSuccess(logsCount.getLogsSuccess());
        jobCount.setLogsError(logsCount.getLogsError());

        // 柱状图
        if (DataUtil.isNotEmpty(dayList)) {
            String[] days = new String[3];
            String[] time = new String[dayList.size()];
            Integer[] succ = new Integer[dayList.size()];
            Integer[] err = new Integer[dayList.size()];
            Integer max = 0;
            for (int i = 0; i < dayList.size(); i++) {
                MainPageVO item = dayList.get(i);
                // 时间
                time[i] = item.getDayTime();
                // 成功数
                succ[i] = item.getLogsSuccess();
                if (succ[i] > max) {
                    max = succ[i];
                }
                // 失败数
                err[i] = item.getLogsError();
                if (err[i] > max) {
                    max = err[i];
                }
            }
            days[0] = JSON.toJSONString(time).replaceAll("\"", "'");
            days[1] = JSON.toJSONString(succ);
            days[2] = JSON.toJSONString(err);
            jobCount.setLogsPerDay(days);
            jobCount.setMax((max / 200 + 1) * 200);
        }

        // 耗时任务排行
        jobCount.setSlowLogList(jobLogService.slowLogs(param));


        mmap.put("data", jobCount);
        mmap.put("version", "1.0.0");
        return "main";
    }

}
