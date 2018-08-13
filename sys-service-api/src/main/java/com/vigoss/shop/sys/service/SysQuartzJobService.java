package com.vigoss.shop.sys.service;

import com.vigoss.shop.sys.entity.QuartzJob;

import java.util.List;
import java.util.Map;

/**
 * 定时任务
 *
 * @author zscat
 * @email 951449465@qq.com
 * @date 2016年11月28日 上午9:55:32
 */
public interface SysQuartzJobService {

    /**
     * 根据ID，查询定时任务
     */
    QuartzJob queryObject(Long jobId);

    /**
     * 查询定时任务列表
     */
    List<QuartzJob> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存定时任务
     */
    void save(QuartzJob scheduleJob);

    /**
     * 更新定时任务
     */
    void update(QuartzJob scheduleJob);

    /**
     * 批量删除定时任务
     */
    void deleteBatch(Long[] jobIds);

    /**
     * 批量更新定时任务状态
     */
    int updateBatch(Long[] jobIds, int status);

    List<QuartzJob> queryList(Long[] jobIds);

    /**
     * 暂停运行
     */
    void pause(Long[] jobIds);

    /**
     * 恢复运行
     */
    void resume(Long[] jobIds);
}
