package com.vigoss.wechat.official.api.impl;

import com.alibaba.fastjson.TypeReference;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.ApiResult;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.OfficialUrlConstant;
import com.vigoss.wechat.base.url.URLManage;
import com.vigoss.wechat.official.api.IOfficialUserApi;
import com.vigoss.wechat.official.api.res.user.UserApiResult;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class OfficialUserApi extends OfficialBaseApi implements IOfficialUserApi {

    public OfficialUserApi(URLManage urlManage, TokenManager tokenManager) {
        super(urlManage, tokenManager);
    }

    @Override
    public UserApiResult getUserInfo(String openid) {
        try {
            Token token = tokenManager.getCache();
            WeixinResponse response = weixinExecutor.get(String.format(
                    getRequestUri(OfficialUrlConstant.user_info_get_uri), token.getAccessToken(), openid, OfficialUrlConstant.lang));
            return response.getAsObject(new TypeReference<UserApiResult>() {
            });
        } catch (WeixinException weixinException) {
            throw weixinException;
        }
    }
}
