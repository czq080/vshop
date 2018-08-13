package com.vigoss.shop.common.exception.cache;


import com.vigoss.shop.common.exception.ShopException;

public class CacheException extends ShopException {
    private static final long serialVersionUID = 1L;

    public CacheException() {
        super();
    }

    public CacheException(String customMsg, Exception e) {
        super(e, customMsg);
    }

    public CacheException(Exception e) {
        super(e);
    }
}
