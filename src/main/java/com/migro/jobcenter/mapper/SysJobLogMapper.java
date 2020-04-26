package com.migro.jobcenter.mapper;

import com.migro.jobcenter.model.SysJobLog;
import top.doublewin.core.base.BaseMapper;

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
}