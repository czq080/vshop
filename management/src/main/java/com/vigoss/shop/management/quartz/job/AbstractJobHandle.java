package com.vigoss.shop.management.quartz.job;

import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.management.api.util.BeanTools;
import com.vigoss.shop.management.quartz.util.ScheduleUtils;
import com.vigoss.shop.sys.entity.QuartzJob;
import com.vigoss.shop.sys.service.SysQuartzJobService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:34 2018/5/27
 * @Modified By:
 */
public abstract class AbstractJobHandle implements Job {
    protected Logger logger;

    public AbstractJobHandle() {
        logger = LoggerFactory.getLogger(getClass());
    }

    public abstract void handle(JobExecutionContext jobExecutionContext) throws InterruptedException;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        SysQuartzJobService sysQuartzJobService = (SysQuartzJobService) BeanTools.getBean(SysQuartzJobService.class);
        String taskid = jobExecutionContext.getJobDetail().getKey().getName();
        logger.info("execute schedule job >> {}", jobExecutionContext.getJobDetail().getKey().getName());
        QuartzJob quartzJob = sysQuartzJobService.queryObject(Long.valueOf(taskid.split(ScheduleUtils.JOB_NAME)[1]));
        quartzJob.setStatus((byte) Constant.ScheduleStatus.RUN.getValue());
        sysQuartzJobService.update(quartzJob);
        try {
            handle(jobExecutionContext);
        } catch (Exception e) {
            logger.error("error schedule job >> {}", jobExecutionContext.getJobDetail().getKey().getName(), e);
        }
        logger.info("complete schedule job >> {}", jobExecutionContext.getJobDetail().getKey().getName());
        quartzJob.setStatus((byte) Constant.ScheduleStatus.NORMAL.getValue());
        sysQuartzJobService.update(quartzJob);
    }
}
