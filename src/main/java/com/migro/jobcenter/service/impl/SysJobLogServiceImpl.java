package com.migro.jobcenter.service.impl;

import com.migro.jobcenter.mapper.SysJobLogMapper;
import com.migro.jobcenter.model.SysJobLog;
import com.migro.jobcenter.model.vo.MainPageVO;
import com.migro.jobcenter.service.ISysJobLogService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.doublewin.core.base.BaseService;

import java.util.List;
import java.util.Map;

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

    @Override
    public MainPageVO jobLogsCount() {
        return mapper.jobLogsCount();
    }

    @Override
    public List<MainPageVO> dayLogs(Map<String, Object> param) {
        return mapper.dayLogs(param);
    }

    @Override
    public List<SysJobLog> slowLogs(Map<String, Object> param) {
        //return mapper.slowLogs(param);
        List<SysJobLog> list = (List<SysJobLog>)super.pagingQuery("slowLogs",param,null);
        return list;
    }
}
