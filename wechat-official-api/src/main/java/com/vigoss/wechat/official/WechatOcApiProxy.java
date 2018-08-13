package com.vigoss.wechat.official;

import com.vigoss.wechat.base.cache.CacheStorager;
import com.vigoss.wechat.base.http.weixin.ApiResult;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.OfficialUrlConstant;
import com.vigoss.wechat.base.url.URLManage;
import com.vigoss.wechat.base.url.WeixinOfficialURLManage;
import com.vigoss.wechat.official.api.IOfficialUserApi;
import com.vigoss.wechat.official.api.impl.OfficialUserApi;
import com.vigoss.wechat.official.api.res.user.UserApiResult;
import com.vigoss.wechat.official.token.WeixinOfficialTicketCreator;
import com.vigoss.wechat.official.token.WeixinOfficialTokenCreator;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class WechatOcApiProxy implements IOfficialUserApi{

    private final IOfficialUserApi officialUserApi;

    private final TokenManager accessTokenManager;

    private final TokenManager ticketManager;

    private final URLManage urlManage;

    public WechatOcApiProxy(Builder builder) {
        this.officialUserApi = builder.officialUserApi;
        this.accessTokenManager = builder.accessTokenManager;
        this.ticketManager = builder.ticketManager;
        this.urlManage = builder.urlManage;
    }

    @Override
    public UserApiResult getUserInfo(String openid) {
        return officialUserApi.getUserInfo(openid);
    }

    public static class Builder {

        private final IOfficialUserApi officialUserApi;

        private final TokenManager accessTokenManager;

        private final TokenManager ticketManager;
        /**
         * token存储
         */
        private final CacheStorager<Token> cacheStorager;

        private final URLManage urlManage;

        public Builder(String appId, String appSecret, CacheStorager<Token> cacheStorager) {
            this.urlManage = new WeixinOfficialURLManage();
            this.accessTokenManager = new TokenManager(new WeixinOfficialTokenCreator(appId, appSecret, urlManage.getValue(OfficialUrlConstant.assess_token_uri)), cacheStorager);
            this.ticketManager = new TokenManager(new WeixinOfficialTicketCreator(appId, urlManage.getValue(OfficialUrlConstant.js_ticket_uri), accessTokenManager), cacheStorager);
            this.cacheStorager = cacheStorager;
            this.officialUserApi = new OfficialUserApi(urlManage, accessTokenManager);
        }

        public WechatOcApiProxy build() {
            return new WechatOcApiProxy(this);
        }
    }
}
