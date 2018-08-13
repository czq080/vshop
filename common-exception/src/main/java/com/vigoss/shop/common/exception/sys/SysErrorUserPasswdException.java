package com.vigoss.shop.common.exception.sys;


import com.vigoss.shop.common.exception.ShopException;

public class SysErrorUserPasswdException extends ShopException {
    private static final long serialVersionUID = 1L;

    public SysErrorUserPasswdException() {
        super();
    }

    public SysErrorUserPasswdException(Exception e) {
        super(e);
    }
}
