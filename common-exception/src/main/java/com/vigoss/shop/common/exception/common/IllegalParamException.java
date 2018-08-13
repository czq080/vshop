package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class IllegalParamException extends ShopException {
	private static final long serialVersionUID = 1L;
	public IllegalParamException() {
		super();
	}
	public IllegalParamException(Exception e) {
		super(e);
	}
}
