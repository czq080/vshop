package com.vigoss.wechat.official.api;

import com.vigoss.wechat.base.http.weixin.ApiResult;
import com.vigoss.wechat.official.api.res.user.UserApiResult;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public interface IOfficialUserApi {

    /**
     * 拉取用户信息（包含UNIONID机制）
     * @param openid
     * @return
     */
    UserApiResult getUserInfo(String openid);
}
