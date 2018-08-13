package com.vigoss.wechat.enterprise.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.EnterpriseUrlConstant;
import com.vigoss.wechat.base.url.URLManage;
import com.vigoss.wechat.enterprise.api.IUserApi;
import com.vigoss.wechat.enterprise.api.req.user.UserTicket;
import com.vigoss.wechat.enterprise.api.res.user.GetUserIdByCodeApiResult;
import com.vigoss.wechat.enterprise.api.res.user.ListUserApiResult;
import com.vigoss.wechat.enterprise.api.res.user.UserApiResult;
import com.vigoss.wechat.enterprise.api.res.user.UserDetailApiResult;

/**
 * @Author:czq
 * @Description: 企业微信成员API
 * @Date: 18:09 2018/3/10
 * @Modified By:
 */
public class UserBaseApi extends EnterpriseBaseApi implements IUserApi {

    public UserBaseApi(URLManage urlManage, TokenManager weixinTokenManager) {
        super(urlManage, weixinTokenManager);
    }

    /**
     * 根据code获取成员ID信息 code只能使用一次，5分钟未被使用自动过期
     */
    @Override
    public GetUserIdByCodeApiResult getUserIdByCode(String code) throws WeixinException {
        try {
            Token token = weixinTokenManager.getCache();
            WeixinResponse response = weixinExecutor.get(String.format(
                    getRequestUri(EnterpriseUrlConstant.user_getid_uri), token.getAccessToken(), code));
            return response.getAsObject(new TypeReference<GetUserIdByCodeApiResult>() {
            });
        } catch (WeixinException weixinException) {
            throw new WeixinException("错误码(微信):" + weixinException.getErrorCode());
        }
    }

    /**
     * 根据user_ticket获取成员信息 ticket有效期为7200秒
     */
    public UserDetailApiResult getUserDetail(UserTicket userTicket) throws WeixinException {
        try {
            Token token = weixinTokenManager.getCache();
            WeixinResponse response = weixinExecutor.post(String.format(
                    getRequestUri(EnterpriseUrlConstant.user_ticket_detail_uri), token.getAccessToken()), JSONObject.toJSONString(userTicket));
            return response.getAsObject(new TypeReference<UserDetailApiResult>() {
            });
        } catch (WeixinException weixinException) {
            throw new WeixinException("错误码(微信):" + weixinException.getErrorCode());
        }
    }

    /**
     * 获取成员信息
     */
    public UserApiResult getUser(String userid) throws WeixinException {
        try {
            Token token = weixinTokenManager.getCache();
            WeixinResponse response = weixinExecutor.get(String.format(
                    getRequestUri(EnterpriseUrlConstant.user_get_uri), token.getAccessToken(), userid));
            return response.getAsObject(new TypeReference<UserApiResult>() {
            });
        } catch (WeixinException weixinException) {
            weixinException.printStackTrace();
            throw new WeixinException("错误码(微信):" + weixinException.getErrorCode());
        }
    }

    /**
     * 获取部门成员详情
     * fetchChild 1/0：是否递归获取子部门下面的成员
     */
    public ListUserApiResult listUserDetail(int partyId, boolean fetchChild, boolean isdetail) throws WeixinException {
        Token token = weixinTokenManager.getCache();
        WeixinResponse response = weixinExecutor.get(String.format(
                isdetail ? getRequestUri(EnterpriseUrlConstant.user_list_uri)
                        : getRequestUri(EnterpriseUrlConstant.user_simplelist_uri), token.getAccessToken(), partyId, fetchChild ? 1
                        : 0));
        return response.getAsObject(new TypeReference<ListUserApiResult>() {
        });
    }
}
