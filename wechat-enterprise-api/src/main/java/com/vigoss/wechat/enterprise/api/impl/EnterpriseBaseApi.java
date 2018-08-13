package com.vigoss.wechat.enterprise.api.impl;

import com.vigoss.wechat.base.api.BaseApi;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.URLManage;

public abstract class EnterpriseBaseApi extends BaseApi {

    protected final TokenManager weixinTokenManager;

    public EnterpriseBaseApi(URLManage urlManage, TokenManager weixinTokenManager) {
        super(urlManage);
        this.weixinTokenManager = weixinTokenManager;
    }
}
