package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class IOErrorException extends ShopException {
    private static final long serialVersionUID = 1L;

    public IOErrorException() {
        super();
    }

    public IOErrorException(Exception e) {
        super(e);
    }
}
