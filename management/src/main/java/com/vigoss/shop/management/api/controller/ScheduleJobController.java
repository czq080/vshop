package com.vigoss.shop.management.api.controller;

import com.alibaba.fastjson.JSON;
import com.vigoss.shop.common.exception.util.StringUtils;
import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.common.utils.PageUtils;
import com.vigoss.shop.common.utils.Query;
import com.vigoss.shop.common.validator.ValidatorUtils;
import com.vigoss.shop.management.api.dto.MQuartzJob;
import com.vigoss.shop.management.quartz.util.ScheduleUtils;
import com.vigoss.shop.sys.entity.QuartzJob;
import com.vigoss.shop.sys.service.SysQuartzJobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("${api.prefix}/schedule")
public class ScheduleJobController extends BaseController {
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private SysQuartzJobService sysQuartzJobService;

    /**
     * 定时任务列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:schedule:list")
    public ResponseEntity list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<QuartzJob> jobList = sysQuartzJobService.queryList(query);
        int total = sysQuartzJobService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(jobList, total, query.getLimit(), query.getPage());
        return setSuccessResponsep(pageUtil);
    }

    /**
     * 定时任务信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("sys:schedule:info")
    public ResponseEntity info(@PathVariable("jobId") Long jobId) {
        QuartzJob schedule = sysQuartzJobService.queryObject(jobId);
        return setSuccessResponsep(schedule);
    }

    /**
     * 保存定时任务
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:schedule:save")
    public ResponseEntity save(@RequestBody MQuartzJob mQuartzJob) {

        ValidatorUtils.validateEntity(mQuartzJob);
        if (mQuartzJob.getParamList() != null && !mQuartzJob.getParamList().isEmpty()) {
            Map<String, String> map = new HashMap<>();
            for (MQuartzJob.Param param : mQuartzJob.getParamList()) {
                String name = param.getName();
                String value = param.getValue();
                if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(value))
                    map.put(name, value);
            }
            mQuartzJob.setParams(JSON.toJSONString(map));
            mQuartzJob.setStatus((byte) Constant.ScheduleStatus.NORMAL.getValue());
        }
        mQuartzJob.setJobId((long) ((System.currentTimeMillis()/1000)*Math.random()));
        sysQuartzJobService.save(mQuartzJob);
        ScheduleUtils.createScheduleJob(scheduler,mQuartzJob);
        return setSuccessResponsep();
    }

    /**
     * 修改定时任务
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:schedule:update")
    public ResponseEntity update(@RequestBody QuartzJob quartzJob) {
        ValidatorUtils.validateEntity(quartzJob);
        sysQuartzJobService.update(quartzJob);
        ScheduleUtils.updateScheduleJob(scheduler,quartzJob);
        return setSuccessResponsep();
    }

    /**
     * 删除定时任务
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:schedule:delete")
    public ResponseEntity delete(@RequestBody Long[] jobIds) {
        sysQuartzJobService.deleteBatch(jobIds);
        for (Long jobId : jobIds) {
            ScheduleUtils.deleteScheduleJob(scheduler,jobId);
        }
        return setSuccessResponsep();
    }

    /**
     * 立即执行任务
     */
    @RequestMapping("/run")
    @RequiresPermissions("sys:schedule:run")
    public ResponseEntity run(@RequestBody Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.run(scheduler, sysQuartzJobService.queryObject(jobId));
        }
        return setSuccessResponsep();
    }

    /**
     * 暂停定时任务
     */
    @RequestMapping("/pause")
    @RequiresPermissions("sys:schedule:pause")
    public ResponseEntity pause(@RequestBody Long[] jobIds) {
        sysQuartzJobService.pause(jobIds);
        for (Long jobId : jobIds) {
            ScheduleUtils.pauseJob(scheduler,jobId);
        }
        return setSuccessResponsep();
    }

    /**
     * 恢复定时任务
     */
    @RequestMapping("/resume")
    @RequiresPermissions("sys:schedule:resume")
    public ResponseEntity resume(@RequestBody Long[] jobIds) {
        sysQuartzJobService.resume(jobIds);
        for (Long jobId : jobIds) {
            ScheduleUtils.resumeJob(scheduler,jobId);
        }
        return setSuccessResponsep();
    }

    /**
     * 校准定时任务
     */
    @RequestMapping("/check")
    @RequiresPermissions("sys:schedule:check")
    public ResponseEntity check(@RequestBody Long[] jobIds) {
        for (Long jobId : jobIds) {
            QuartzJob schedule = sysQuartzJobService.queryObject(jobId);
        }
        return setSuccessResponsep();
    }
}
