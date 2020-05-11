package com.migro.jobcenter.mapper;

import com.migro.jobcenter.model.SysJob;
import com.migro.jobcenter.model.vo.MainPageVO;
import top.doublewin.core.base.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author migro
 * @since 2020-04-03
 */
public interface SysJobMapper extends BaseMapper<SysJob> {

    /**
     * 查询所有调度任务
     *
     * @return 调度任务列表
     */
    List<SysJob> selectJobAll();

    MainPageVO jobCount();

}