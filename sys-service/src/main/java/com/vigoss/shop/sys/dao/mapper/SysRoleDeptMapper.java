package com.vigoss.shop.sys.dao.mapper;

import com.vigoss.shop.sys.entity.SysRoleDept;
import java.util.List;
import java.util.Map;

public interface SysRoleDeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int insert(SysRoleDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    SysRoleDept selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    List<SysRoleDept> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_dept
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    int updateByPrimaryKey(SysRoleDept record);

    /**
     * 根据角色ID，获取部门ID列表
     */
    List<Long> queryDeptIdList(Long roleId);

    /**
     * 根据用户ID获取权限部门列表
     *
     * @param userId
     * @return
     */
    List<Long> queryDeptIdListByUserId(Long userId);

    void save(Map<String, Object> map);

    int delete(Object id);
}