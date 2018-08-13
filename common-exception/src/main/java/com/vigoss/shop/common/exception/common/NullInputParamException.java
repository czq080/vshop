package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class NullInputParamException extends ShopException {
	private static final long serialVersionUID = 1L;
	public NullInputParamException() {
		super();
	}
	public NullInputParamException(Exception e) {
		super(e);
	}
}
