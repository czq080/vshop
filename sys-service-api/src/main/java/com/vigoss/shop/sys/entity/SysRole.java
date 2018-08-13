package com.vigoss.shop.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.role_name
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.remark
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.create_user_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Long createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.create_time
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role.dept_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Long deptId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_id
     *
     * @return the value of sys_role.role_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_id
     *
     * @param roleId the value for sys_role.role_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.role_name
     *
     * @return the value of sys_role.role_name
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.role_name
     *
     * @param roleName the value for sys_role.role_name
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.remark
     *
     * @return the value of sys_role.remark
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.remark
     *
     * @param remark the value for sys_role.remark
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_user_id
     *
     * @return the value of sys_role.create_user_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_user_id
     *
     * @param createUserId the value for sys_role.create_user_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.create_time
     *
     * @return the value of sys_role.create_time
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.create_time
     *
     * @param createTime the value for sys_role.create_time
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_role.dept_id
     *
     * @return the value of sys_role.dept_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_role.dept_id
     *
     * @param deptId the value for sys_role.dept_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}