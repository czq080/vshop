package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class ConnectTimeoutExtraException extends ShopException {
    private static final long serialVersionUID = 1L;

    public ConnectTimeoutExtraException() {
        super();
    }

    public ConnectTimeoutExtraException(Exception e) {
        super(e);
    }
}
