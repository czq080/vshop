package com.vigoss.shop.common.exception.sys;


import com.vigoss.shop.common.exception.ShopException;

public class SysQuartzException extends ShopException {
    private static final long serialVersionUID = 1L;

    public SysQuartzException() {
    }

    public SysQuartzException(Exception e) {
        super(e);
    }

    public SysQuartzException(String customMsg) {
        super(customMsg);
    }

    public SysQuartzException(Exception e, String customMsg) {
        super(e, customMsg);
    }
}
