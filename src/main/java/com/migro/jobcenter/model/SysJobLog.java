package com.migro.jobcenter.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统任务执行记录表
 * </p>
 *
 * @author migro
 * @since 2020-04-03
 */
@ApiModel("系统任务执行记录表")
@SuppressWarnings("serial")
public class SysJobLog extends BaseModel {

    @ApiModelProperty(value = "任务名称 ")
    private String jobName;
    @ApiModelProperty(value = "任务组名")
    private String jobGroup;
    @ApiModelProperty(value = "调用目标字符串")
    private String invokeTarget;
    @ApiModelProperty(value = "日志信息")
    private String jobMessage;
    @ApiModelProperty(value = "执行状态   1--正常 0--失败")
    private Integer status;
    @ApiModelProperty(value = "异常信息")
    private String exceptionInfo;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "耗时（毫秒）")
    private Long timeCost;

    @TableField(exist = false)
    private Date startTime;
    @TableField(exist = false)
    private Date stopTime;
    @TableField(exist = false)
    private Integer pageSize;
    @TableField(exist = false)
    private Integer pageNumber;
    @TableField(exist = false)
    private List<String> searchTime;


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getInvokeTarget() {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    public String getJobMessage() {
        return jobMessage;
    }

    public void setJobMessage(String jobMessage) {
        this.jobMessage = jobMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Long timeCost) {
        this.timeCost = timeCost;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<String> getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(List<String> searchTime) {
        this.searchTime = searchTime;
    }
}