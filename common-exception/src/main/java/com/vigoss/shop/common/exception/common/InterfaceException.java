package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class InterfaceException extends ShopException {
	private static final long serialVersionUID = 1L;
	public InterfaceException() {
		super();
	}
	public InterfaceException(Exception e) {
		super(e);
	}
}
