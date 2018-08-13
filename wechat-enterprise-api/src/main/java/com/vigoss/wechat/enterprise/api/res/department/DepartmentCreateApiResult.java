package com.vigoss.wechat.enterprise.api.res.department;


import com.vigoss.wechat.base.http.weixin.ApiResult;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:21 2018/3/10
 * @Modified By:
 */
public class DepartmentCreateApiResult extends ApiResult {

    /**
     * errcode : 0
     * errmsg : created
     * id : 2
     */

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
