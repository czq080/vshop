package com.vigoss.wechat.enterprise.token;

import com.alibaba.fastjson.JSONObject;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenCreator;

public class WeixinEpTokenCreator extends TokenCreator {
    private final String corpId;
    private final Integer agentId;
    private final String corpSecret;
    private final String url;

    public WeixinEpTokenCreator(String corpId, Integer agentId, String corpSecret, String url) {
        this.corpId = corpId;
        this.agentId = agentId;
        this.corpSecret = corpSecret;
        this.url = url;
    }

    @Override
    public String name() {
        return "enterprise:token:" + this.corpId;
    }

    @Override
    public String uniqueid() {
        return String.valueOf(this.agentId);
    }

    @Override
    public Token create() throws WeixinException {
        String tokenUrl = String.format(url, corpId, corpSecret);
        WeixinResponse response = weixinExecutor.get(tokenUrl);
        JSONObject result = response.getAsJson();
        return new Token(result.getString("access_token"),
                result.getLongValue("expires_in") * 1000l);
    }
}
