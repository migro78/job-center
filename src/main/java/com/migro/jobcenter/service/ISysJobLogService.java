package com.migro.jobcenter.service;

import com.migro.jobcenter.model.SysJobLog;
import top.doublewin.core.base.IBaseService;

/**
 * <p>
 * 系统任务执行记录表  服务类
 * </p>
 *
 * @author migro
 * @since 2020-04-03
 */
public interface ISysJobLogService extends IBaseService<SysJobLog> {
	void cleanJobLogs();
}