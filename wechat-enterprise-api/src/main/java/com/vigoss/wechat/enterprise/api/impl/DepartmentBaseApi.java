package com.vigoss.wechat.enterprise.api.impl;

import com.alibaba.fastjson.TypeReference;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.EnterpriseUrlConstant;
import com.vigoss.wechat.enterprise.api.IDepartmentApi;
import com.vigoss.wechat.enterprise.api.res.department.DepartmentListApiResult;
import com.vigoss.wechat.base.url.URLManage;

/**
 * @Author:czq
 * @Description: 企业微信部门API
 * @Date: 18:09 2018/3/10
 * @Modified By:
 */
public class DepartmentBaseApi extends EnterpriseBaseApi implements IDepartmentApi {

    public DepartmentBaseApi(URLManage urlManage, TokenManager weixinTokenManager) {
        super(urlManage, weixinTokenManager);
    }

    /**
     * 获取指定部门及其下的子部门。 如果部门id为NULL或空，默认获取全量组织架构
     */
    @Override
    public DepartmentListApiResult getDepartmentList(Integer departmentId) throws WeixinException {
        try {
            Token token = weixinTokenManager.getCache();
            String url = String.format(
                    getRequestUri(EnterpriseUrlConstant.department_list_uri), token.getAccessToken());
            if (departmentId != null) {
                url += String.format("&id=%s", departmentId);
            }
            WeixinResponse response = weixinExecutor.get(url);
            return response.getAsObject(new TypeReference<DepartmentListApiResult>() {
            });
        } catch (WeixinException weixinException) {
            throw new WeixinException("错误码(微信):" + weixinException.getErrorCode());
        }
    }
}
