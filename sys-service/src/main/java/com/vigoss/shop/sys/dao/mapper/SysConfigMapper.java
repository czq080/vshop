package com.vigoss.shop.sys.dao.mapper;

import com.vigoss.shop.sys.entity.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysConfigMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int insert(SysConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    SysConfig selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    List<SysConfig> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_config
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int updateByPrimaryKey(SysConfig record);

    int deleteBatch(Long[] id);

    List<SysConfig> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);

    /**
     * 根据key，更新value
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);
}