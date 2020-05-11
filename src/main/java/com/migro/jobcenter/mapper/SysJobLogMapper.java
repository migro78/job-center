package com.migro.jobcenter.mapper;

import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.model.vo.MainPageVO;
import top.doublewin.core.base.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author migro
 * @since 2020-04-03
 */
public interface SysJobLogMapper extends BaseMapper<SysJobLog> {
    void cleanJobLogs();

    MainPageVO jobLogsCount();

    List<MainPageVO> dayLogs(Map<String,Object> param);

    List<SysJobLog> slowLogs(Map<String,Object> param);
}