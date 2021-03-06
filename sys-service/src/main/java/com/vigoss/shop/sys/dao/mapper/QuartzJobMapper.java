package com.vigoss.shop.sys.dao.mapper;

import com.vigoss.shop.sys.entity.QuartzJob;
import java.util.List;
import java.util.Map;

public interface QuartzJobMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quartz_job
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    int deleteByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quartz_job
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    int insert(QuartzJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quartz_job
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    QuartzJob selectByPrimaryKey(Long jobId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quartz_job
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    List<QuartzJob> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quartz_job
     *
     * @mbggenerated Sun May 27 13:16:13 CST 2018
     */
    int updateByPrimaryKey(QuartzJob record);

    /**
     * 批量更新状态
     */
    int updateBatch(Map<String, Object> map);

    int deleteBatch(Long[] id);

    List<QuartzJob> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    List<QuartzJob> selectListByPrimaryKey(Long[] id);
}