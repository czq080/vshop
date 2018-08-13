package com.vigoss.wechat.base.token;


import com.vigoss.wechat.base.http.weixin.WeixinRequestExecutor;
import com.vigoss.wechat.base.cache.CacheCreator;
import com.vigoss.wechat.base.http.weixin.WeixinRequestExecutor;
import com.vigoss.wechat.base.model.Token;

public abstract class TokenCreator implements CacheCreator<Token> {

    /**
     * 缓存KEY前缀
     */
    public final static String CACHEKEY_PREFIX = "vigoss:wechat:";

    protected final WeixinRequestExecutor weixinExecutor;

    public TokenCreator() {
        this.weixinExecutor = WeixinRequestExecutor.getInstance();
    }

    /**
     * 缓存key:附加key前缀
     *
     * @return
     */
    @Override
    public String key() {
        return String.format("%s%s:%s", CACHEKEY_PREFIX, name(), uniqueid());
    }

    /**
     * 返回缓存类型命名，如mp_token
     *
     * @return
     */
    public abstract String name();

    /**
     * 返回缓存唯一标识，如appid
     *
     * @return
     */
    public abstract String uniqueid();
}
