package com.migro.jobcenter.web;

import com.alibaba.fastjson.JSON;
import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.service.ISysJobLogService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.doublewin.core.base.BaseController;
import top.doublewin.core.util.DataUtil;
import top.doublewin.core.util.DateUtil;

import java.util.Map;

/**
 * <p>
 * 系统任务日志接口
 * </p>
 *
 * @author migro
 * @since 2020/4/26 17:08
 */
@Controller
@RequestMapping("/jobLog/")
@Api(value = "任务日志表接口", description = "任务日志表接口")
public class JobLogController extends BaseController<SysJobLog, ISysJobLogService> {
    @GetMapping("view")
    public String jobLogView() {
        return "job/jobLog";
    }


    @PostMapping("list")
    @ResponseBody
    public Object jobLogList(ModelMap modelMap, SysJobLog param) {
        Map map = (Map) JSON.parse(JSON.toJSONString(param));
        // 处理查询时间
        if(DataUtil.isNotEmpty(param.getSearchTime())){
            if(param.getSearchTime().size()>0){
                if(DataUtil.isNotEmpty(param.getSearchTime().get(0))) {
                    map.put("searchTimeStart", DateUtil.stringToDate(param.getSearchTime().get(0)));
                }
            }
            if(param.getSearchTime().size()>1){
                if(DataUtil.isNotEmpty(param.getSearchTime().get(1))) {
                    map.put("searchTimeEnd", DateUtil.stringToDate(param.getSearchTime().get(1)+ " 23:59:59"));
                }
            }
        }
        return super.pagingQuery(modelMap, map);
    }


    @GetMapping("/remove/{ids}")
    @ResponseBody
    public Object remove(@PathVariable("ids") Long[] ids) {
        service.deleteByIds(ids);
        return super.setSuccessModelMap();
    }


    @GetMapping("/detail/{jobLogId}")
    public String detail(@PathVariable("jobLogId") Long jobLogId, ModelMap mmap) {
        mmap.put("name", "jobLog");
        mmap.put("jobLog", service.queryById(jobLogId));
        return "job/detail";
    }

    @PostMapping("/clean")
    @ResponseBody
    public Object clean() {
        service.cleanJobLogs();
        return super.setSuccessModelMap();
    }
}
