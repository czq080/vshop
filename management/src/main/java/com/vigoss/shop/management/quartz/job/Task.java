package com.vigoss.shop.management.quartz.job;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:34 2018/5/27
 * @Modified By:
 */
public class Task extends AbstractJobHandle{
    @Override
    public void handle(JobExecutionContext jobExecutionContext) throws InterruptedException {
        System.out.println(new Date());
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println(dataMap.get("name"));
        System.out.println(dataMap.get("hwo"));
        Thread.sleep(10000);
    }
}
