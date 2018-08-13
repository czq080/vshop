package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class InputParamException extends ShopException {
    private static final long serialVersionUID = 1L;

    public InputParamException() {
        super();
    }

    public InputParamException(String customMsg) {
        super(customMsg);
    }

    public InputParamException(Exception e) {
        super(e);
    }
}
