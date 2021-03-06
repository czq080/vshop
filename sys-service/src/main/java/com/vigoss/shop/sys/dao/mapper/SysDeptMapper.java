package com.vigoss.shop.sys.dao.mapper;

import com.vigoss.shop.sys.entity.SysDept;
import java.util.List;
import java.util.Map;

public interface SysDeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int deleteByPrimaryKey(Long deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int insert(SysDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    SysDept selectByPrimaryKey(Long deptId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    List<SysDept> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int updateByPrimaryKey(SysDept record);

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

    int deleteWithFlag(Long id);

    List<SysDept> queryList(Map<String, Object> map);
}