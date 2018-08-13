package com.vigoss.wechat.enterprise.api.res.department;

import com.vigoss.wechat.base.http.weixin.ApiResult;
import com.vigoss.wechat.enterprise.api.req.department.Department;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:19 2018/3/10
 * @Modified By:
 */
public class DepartmentListApiResult extends ApiResult {

    /**
     * errcode : 0
     * errmsg : ok
     * department : [{"id":2,"name":"广州研发中心","parentid":1,"order":10},{"id":3,"name":"邮箱产品部","parentid":2,"order":40}]
     */
    private List<Department> department;

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
}
