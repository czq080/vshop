package com.vigoss.wechat.base.token;

import com.vigoss.wechat.base.cache.CacheManager;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.cache.CacheManager;
import com.vigoss.wechat.base.cache.CacheStorager;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.model.Token;

public class TokenManager extends CacheManager<Token> {
    /**
     *
     * @param tokenCreator
     *            负责微信各种token的创建
     * @param cacheStorager
     *            负责token的存储
     */
    public TokenManager(TokenCreator tokenCreator, CacheStorager<Token> cacheStorager) {
        super(tokenCreator, cacheStorager);
    }

    /**
     * 获取token字符串
     *
     * @return token字符串
     * @throws WeixinException
     */
    public String getAccessToken() throws WeixinException {
        return super.getCache().getAccessToken();
    }

    /**
     * 返回唯一标识ID
     *
     * @return
     */
    public String getWeixinId() {
        return ((TokenCreator) cacheCreator).uniqueid();
    }
}
