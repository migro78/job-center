package com.migro.jobcenter.web;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.model.SysJob;
import com.migro.jobcenter.service.ISysJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.doublewin.core.base.BaseController;

import java.util.Map;

/**
 * <p>
 * 系统任务管理接口
 * </p>
 *
 * @author migro
 * @since 2020/4/23 16:45
 */
@Controller
@RequestMapping("/job/")
@Api(value = "系统任务表接口", description = "系统任务表接口")
public class JobController extends BaseController<SysJob, ISysJobService> {

    @GetMapping("view")
    public String jobView() {
        return "job/job";
    }

    @GetMapping("add")
    public String addJobView() {
        return "job/add";
    }

    @PostMapping("add")
    @ResponseBody
    public Object addJob(@Validated SysJob job) {
        try {
            service.insertJob(job);
        } catch (Exception e) {
            logger.error(e, e);
            throw new RuntimeException("创建系统任务失败，原因：" + e.getMessage());
        }
        return super.setSuccessModelMap();
    }

    @PostMapping("list")
    @ResponseBody
    public Object jobList(ModelMap modelMap, SysJob param) {
        Map map = (Map) JSON.parse(JSON.toJSONString(param));
        return super.pagingQuery(modelMap, map);
    }

    @GetMapping(value = "read/{jobId}")
    @ApiOperation(value = "系统任务表详情")
    public Object get(ModelMap modelMap, @PathVariable("jobId") Long jobId) {
        modelMap.put("name", "job");
        modelMap.put("job", service.queryById(jobId));
        return "job/detail";
    }

    /**
     * 任务调度状态修改
     */
    @PostMapping("changeStatus")
    @ResponseBody
    public Object changeStatus(SysJob job) {
        SysJob newJob = service.queryById(job.getId());
        newJob.setStatus(job.getStatus());
        try {
            service.changeStatus(newJob);
        } catch (SchedulerException e) {
            logger.error(e, e);
            throw new RuntimeException("系统任务状态修改失败，原因：" + e.getMessage());
        }
        return super.setSuccessModelMap();
    }

    /**
     * 修改调度
     */
    @GetMapping("/edit/{jobId}")
    public String edit(@PathVariable("jobId") Long jobId, ModelMap mmap) {
        mmap.put("job", service.queryById(jobId));
        return "job/edit";
    }

    /**
     * 修改保存调度
     */
    @PostMapping("/edit")
    @ResponseBody
    public Object editSave(@Validated SysJob job) {
        try {
            service.updateJob(job);
        } catch (Exception e) {
            logger.error(e, e);
            throw new RuntimeException("修改系统任务失败，原因：" + e.getMessage());
        }
        return super.setSuccessModelMap();
    }

    @GetMapping("/remove/{jobIds}")
    @ResponseBody
    public Object remove(@PathVariable Long[] jobIds) throws SchedulerException {
        logger.debug("删除系统任务表, ids is {}", jobIds);
        service.deleteJobByIds(jobIds);
        return super.setSuccessModelMap();
    }

    /**
     * 任务调度立即执行一次
     */
    @PostMapping("/run")
    @ResponseBody
    public Object run(SysJob job) throws SchedulerException
    {
        service.run(job);
        return super.setSuccessModelMap();
    }


    /**
     * 校验cron表达式是否有效
     */
    @PostMapping("/checkCronExpressionIsValid")
    @ResponseBody
    public boolean checkCronExpressionIsValid(SysJob job)
    {
        return service.checkCronExpressionIsValid(job.getCronExpression());
    }

}
