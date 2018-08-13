package com.vigoss.shop.common.exception.weixin;


import com.vigoss.shop.common.exception.ShopException;

public abstract class WeixinBaseException extends ShopException {
    private static final long serialVersionUID = 1L;

    public WeixinBaseException() {
        super();
    }

    public WeixinBaseException(String customMsg) {
        super(customMsg);
    }

    public WeixinBaseException(String customMsg, Exception e) {
        super(e, customMsg);
    }

    public WeixinBaseException(Exception e) {
        super(e);
    }
}
