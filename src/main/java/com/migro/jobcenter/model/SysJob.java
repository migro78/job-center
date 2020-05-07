package com.migro.jobcenter.model;

import com.migro.jobcenter.utils.CronUtils;
import com.migro.jobcenter.utils.StringUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import top.doublewin.core.base.BaseModel;

import java.util.Date;

/**
 * <p>
 * 系统任务表
 * </p>
 *
 * @author migro
 * @since 2020-04-03
 */
@ApiModel("系统任务表")
@SuppressWarnings("serial")
public class SysJob extends BaseModel {

    @ApiModelProperty(value = "任务名称")
    private String jobName;
    @ApiModelProperty(value = "任务组名")
    private String jobGroup;
    @ApiModelProperty(value = "调用目标字符串")
    private String invokeTarget;
    @ApiModelProperty(value = "cron执行表达式")
    private String cronExpression;
    @ApiModelProperty(value = "计划执行错误策略   1--立即执行 2--执行一次 3--放弃执行")
    private Integer misfirePolicy;
    @ApiModelProperty(value = "是否并发执行  0--禁止 1--允许")
    private Integer concurrent;
    @ApiModelProperty(value = "状态   0--暂停 1--正常")
    private Integer status;
    @ApiModelProperty(value = "创建者")
    private Long createBy;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新者")
    private Long updateBy;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "备注信息")
    private String remark;
    @ApiModelProperty(value = "调用类型  1--dubbo  2--bean")
    private Integer invokeType;
    @ApiModelProperty(value = "dubbo应用名称")
    private String applicationName;
    @ApiModelProperty(value = "异步调用 1--异步  0--同步")
    private Integer async;


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

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Integer getMisfirePolicy() {
        return misfirePolicy;
    }

    public void setMisfirePolicy(Integer misfirePolicy) {
        this.misfirePolicy = misfirePolicy;
    }

    public Integer getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(Integer concurrent) {
        this.concurrent = concurrent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(Integer invokeType) {
        this.invokeType = invokeType;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Integer getAsync() {
        return async;
    }

    public void setAsync(Integer async) {
        this.async = async;
    }

    public Date getNextValidTime() {
        if (StringUtils.isNotEmpty(cronExpression)) {
            return CronUtils.getNextExecution(cronExpression);
        }
        return null;
    }

}