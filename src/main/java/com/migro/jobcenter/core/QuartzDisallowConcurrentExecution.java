package com.migro.jobcenter.core;

import com.migro.jobcenter.model.SysJob;
import com.migro.jobcenter.utils.BeanInvokeUtil;
import com.migro.jobcenter.utils.DubboInvokeUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import top.doublewin.core.util.DataUtil;

/**
 * 定时任务处理（禁止并发执行）
 *
 * @author ruoyi
 */
@DisallowConcurrentExecution
public class QuartzDisallowConcurrentExecution extends AbstractQuartzJob {
    @Override
    protected Object doExecute(JobExecutionContext context, SysJob sysJob) throws Exception {
        Object ret = null;
        if (DataUtil.isNotEmpty(sysJob)) {
            if (DataUtil.isNotEmpty(sysJob.getInvokeType()) && sysJob.getInvokeType() == 1) {
                ret = DubboInvokeUtil.invokeMethod(sysJob);
            } else {
                ret = BeanInvokeUtil.invokeMethod(sysJob);
            }
        }
        return ret;
    }
}
