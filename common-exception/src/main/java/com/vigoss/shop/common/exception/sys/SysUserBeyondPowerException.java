package com.vigoss.shop.common.exception.sys;


import com.vigoss.shop.common.exception.ShopException;

public class SysUserBeyondPowerException extends ShopException {
    private static final long serialVersionUID = 1L;

    public SysUserBeyondPowerException() {
        super();
    }

    public SysUserBeyondPowerException(Exception e) {
        super(e);
    }
}
