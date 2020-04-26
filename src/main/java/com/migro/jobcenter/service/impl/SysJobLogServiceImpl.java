package com.migro.jobcenter.service.impl;

import com.migro.jobcenter.mapper.SysJobLogMapper;
import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.service.ISysJobLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.doublewin.core.base.BaseService;

/**
 * <p>
 * 系统任务执行记录表 服务实现类
 * </p>
 *
 * @author migro
 * @since 2020-04-03
 */
@Service(interfaceClass = ISysJobLogService.class)
@Component
public class SysJobLogServiceImpl extends BaseService<SysJobLog, SysJobLogMapper> implements ISysJobLogService {

    @Override
    public void cleanJobLogs() {
        mapper.cleanJobLogs();
    }
}
