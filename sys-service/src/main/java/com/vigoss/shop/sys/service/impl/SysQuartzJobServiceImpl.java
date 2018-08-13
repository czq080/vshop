package com.vigoss.shop.sys.service.impl;

import com.vigoss.shop.common.utils.Constant;
import com.vigoss.shop.sys.dao.mapper.QuartzJobMapper;
import com.vigoss.shop.sys.entity.QuartzJob;
import com.vigoss.shop.sys.service.SysQuartzJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author zscat
 * @email 951449465@qq.com
 * @date 2016年11月28日 上午9:55:32
 */
@Service
public class SysQuartzJobServiceImpl implements SysQuartzJobService {
    @Autowired
    private QuartzJobMapper quartzJobMapper;

    @Override
    public QuartzJob queryObject(Long jobId) {
        return quartzJobMapper.selectByPrimaryKey(jobId);
    }

    @Override
    public List<QuartzJob> queryList(Map<String, Object> map) {
        return quartzJobMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return quartzJobMapper.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(QuartzJob scheduleJob) {
        scheduleJob.setCreateTime(new Date());
        quartzJobMapper.insert(scheduleJob);
    }

    @Override
    @Transactional
    public void update(QuartzJob scheduleJob) {
        quartzJobMapper.updateByPrimaryKey(scheduleJob);
    }

    @Override
    @Transactional
    public void deleteBatch(Long[] jobIds) {
        //删除数据
        quartzJobMapper.deleteBatch(jobIds);
    }

    @Override
    public int updateBatch(Long[] jobIds, int status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", jobIds);
        map.put("status", status);
        return quartzJobMapper.updateBatch(map);
    }

    @Override
    @Transactional
    public List<QuartzJob> queryList(Long[] jobIds) {
        return quartzJobMapper.selectListByPrimaryKey(jobIds);
    }

    @Override
    @Transactional
    public void pause(Long[] jobIds) {
        updateBatch(jobIds, Constant.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    @Transactional
    public void resume(Long[] jobIds) {
        updateBatch(jobIds, Constant.ScheduleStatus.NORMAL.getValue());
    }
}
