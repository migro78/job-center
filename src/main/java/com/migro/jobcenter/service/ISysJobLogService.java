package com.migro.jobcenter.service;

import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.model.vo.MainPageVO;
import top.doublewin.core.base.IBaseService;

import java.util.List;
import java.util.Map;

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
	/**
	 * 查询日志数量统计
	 * @param
	 * @return
	 */
	MainPageVO jobLogsCount();

	/**
	 * 查询最近几天每日日志数量统计
	 * @param
	 * @return
	 */
	List<MainPageVO> dayLogs(Map<String,Object> param);

	/**
	 * 查询最近几天耗时最长的任务执行记录
	 * @param
	 * @return
	 */
	List<SysJobLog> slowLogs(Map<String,Object> param);
}