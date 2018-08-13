package com.vigoss.wechat.enterprise.api.req.department;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:17 2018/3/10
 * @Modified By:
 */
public class Department {

    /**
     * name : 广州研发中心
     * parentid : 1
     * order : 1
     * id : 2
     */

    private String name;
    private int parentid;
    private int order;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
