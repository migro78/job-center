package com.migro.jobcenter.model.vo;

import com.migro.jobcenter.model.SysJobLog;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述
 * </p>
 *
 * @author migro
 * @since 2020/5/9 10:18
 */
public class MainPageVO implements Serializable {
    private String dayTime;
    private Integer jobTotal;
    private Integer jobRun;
    private Integer jobPause;
    private Integer logsTotal;
    private Integer logsSuccess;
    private Integer logsError;
    private List<SysJobLog> slowLogList;
    private String[] logsPerDay;
    private Integer max;

    public Integer getJobTotal() {
        return jobTotal;
    }

    public void setJobTotal(Integer jobTotal) {
        this.jobTotal = jobTotal;
    }

    public Integer getJobRun() {
        return jobRun;
    }

    public void setJobRun(Integer jobRun) {
        this.jobRun = jobRun;
    }

    public Integer getJobPause() {
        return jobPause;
    }

    public void setJobPause(Integer jobPause) {
        this.jobPause = jobPause;
    }

    public Integer getLogsTotal() {
        return logsTotal;
    }

    public void setLogsTotal(Integer logsTotal) {
        this.logsTotal = logsTotal;
    }

    public Integer getLogsSuccess() {
        return logsSuccess;
    }

    public void setLogsSuccess(Integer logsSuccess) {
        this.logsSuccess = logsSuccess;
    }

    public Integer getLogsError() {
        return logsError;
    }

    public void setLogsError(Integer logsError) {
        this.logsError = logsError;
    }

    public List<SysJobLog> getSlowLogList() {
        return slowLogList;
    }

    public void setSlowLogList(List<SysJobLog> slowLogList) {
        this.slowLogList = slowLogList;
    }

    public String[] getLogsPerDay() {
        return logsPerDay;
    }

    public void setLogsPerDay(String[] logsPerDay) {
        this.logsPerDay = logsPerDay;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
