package com.vigoss.shop.sys.entity;

import java.io.Serializable;

public class SysMenu implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.menu_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Long menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.parent_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.name
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.url
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.perms
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private String perms;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.type
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.icon
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private String icon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.order_num
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Integer orderNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.status
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.menu_id
     *
     * @return the value of sys_menu.menu_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.menu_id
     *
     * @param menuId the value for sys_menu.menu_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.parent_id
     *
     * @return the value of sys_menu.parent_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.parent_id
     *
     * @param parentId the value for sys_menu.parent_id
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.name
     *
     * @return the value of sys_menu.name
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.name
     *
     * @param name the value for sys_menu.name
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.url
     *
     * @return the value of sys_menu.url
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.url
     *
     * @param url the value for sys_menu.url
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.perms
     *
     * @return the value of sys_menu.perms
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public String getPerms() {
        return perms;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.perms
     *
     * @param perms the value for sys_menu.perms
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.type
     *
     * @return the value of sys_menu.type
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.type
     *
     * @param type the value for sys_menu.type
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.icon
     *
     * @return the value of sys_menu.icon
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.icon
     *
     * @param icon the value for sys_menu.icon
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.order_num
     *
     * @return the value of sys_menu.order_num
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.order_num
     *
     * @param orderNum the value for sys_menu.order_num
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.status
     *
     * @return the value of sys_menu.status
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.status
     *
     * @param status the value for sys_menu.status
     *
     * @mbggenerated Mon May 21 20:20:06 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}