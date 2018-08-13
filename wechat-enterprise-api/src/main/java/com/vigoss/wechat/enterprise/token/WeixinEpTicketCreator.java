package com.vigoss.wechat.enterprise.token;

import com.alibaba.fastjson.JSONObject;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenCreator;
import com.vigoss.wechat.base.token.TokenManager;

public class WeixinEpTicketCreator extends TokenCreator {

    private final String corpId;
    private final Integer agentId;
    private final String url;
    private final TokenManager weixinTokenManager;

    /**
     * @param corpId
     * @param agentId
     * @param url
     * @param weixinTokenManager
     */
    public WeixinEpTicketCreator(String corpId, Integer agentId, String url, TokenManager weixinTokenManager) {
        this.corpId = corpId;
        this.agentId = agentId;
        this.url = url;
        this.weixinTokenManager = weixinTokenManager;
    }

    @Override
    public String name() {
        return String.format("enterprise:ticket:%s:%s", "jsapi", this.corpId);
    }

    @Override
    public String uniqueid() {
        return String.valueOf(this.agentId);
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
