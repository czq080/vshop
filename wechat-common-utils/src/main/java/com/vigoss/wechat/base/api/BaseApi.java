package com.vigoss.wechat.base.api;

import com.vigoss.wechat.base.http.weixin.WeixinRequestExecutor;
import com.vigoss.wechat.base.url.URLManage;

public abstract class BaseApi {

    protected final WeixinRequestExecutor weixinExecutor;

    private final URLManage urlManage;

    public BaseApi(URLManage urlManage) {
        this.urlManage = urlManage;
        this.weixinExecutor = WeixinRequestExecutor.getInstance();
    }

    protected String getRequestUri(String key) {
        return urlManage.getValue(key);
    }
}
