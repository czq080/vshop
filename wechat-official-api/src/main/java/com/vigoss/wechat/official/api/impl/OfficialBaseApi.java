package com.vigoss.wechat.official.api.impl;

import com.vigoss.wechat.base.api.BaseApi;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.URLManage;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public abstract class OfficialBaseApi extends BaseApi {

    protected final TokenManager tokenManager;

    public OfficialBaseApi(URLManage urlManage, TokenManager tokenManager) {
        super(urlManage);
        this.tokenManager = tokenManager;
    }
}
