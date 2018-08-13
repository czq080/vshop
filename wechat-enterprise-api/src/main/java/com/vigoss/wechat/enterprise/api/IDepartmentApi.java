package com.vigoss.wechat.enterprise.api;

import com.vigoss.wechat.enterprise.api.res.department.DepartmentListApiResult;

/**
 * @Author:czq
 * @Description:
 * @Date: 17:57 2018/3/3
 * @Modified By:
 */
public interface IDepartmentApi {
    DepartmentListApiResult getDepartmentList(Integer departmentId);
}
