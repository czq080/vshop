package com.vigoss.wechat.official.token;

import com.alibaba.fastjson.JSONObject;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenCreator;
import com.vigoss.wechat.base.token.TokenManager;

public class WeixinOfficialTicketCreator extends TokenCreator {

    private final String appId;
    private final String url;
    private final TokenManager weixinTokenManager;

    /**
     * @param appId
     * @param url
     * @param weixinTokenManager
     */
    public WeixinOfficialTicketCreator(String appId, String url, TokenManager weixinTokenManager) {
        this.appId = appId;
        this.url = url;
        this.weixinTokenManager = weixinTokenManager;
    }

    @Override
    public String name() {
        return String.format("official:ticket:%s:%s", "jsapi", this.appId);
    }

    @Override
    public String uniqueid() {
        return String.valueOf(this.appId);
    }

    @Override
    public Token create() throws WeixinException {
        WeixinResponse response;
        response = weixinExecutor.get(String.format(url, weixinTokenManager.getCache().getAccessToken()));
        JSONObject result = response.getAsJson();
        return new Token(result.getString("ticket"),
                result.getLong("expires_in") * 1000l).pushExtra("group_id",
                result.getString("group_id"));
    }
}
