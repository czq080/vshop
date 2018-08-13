package com.vigoss.wechat.official.token;

import com.alibaba.fastjson.JSONObject;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenCreator;

public class WeixinOfficialTokenCreator extends TokenCreator {
    private final String appId;
    private final String appSecret;
    private final String url;

    public WeixinOfficialTokenCreator(String appId, String appSecret, String url) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.url = url;
    }

    @Override
    public String name() {
        return "official:token:" + this.appId;
    }

    @Override
    public String uniqueid() {
        return String.valueOf(this.appId);
    }

    @Override
    public Token create() throws WeixinException {
        String tokenUrl = String.format(url, appId, appSecret);
        WeixinResponse response = weixinExecutor.get(tokenUrl);
        JSONObject result = response.getAsJson();
        return new Token(result.getString("access_token"),
                result.getLongValue("expires_in") * 1000l);
    }
}
