package com.vigoss.shop.common.exception.common;


import com.vigoss.shop.common.exception.ShopException;

public class NetworkException extends ShopException {
	private static final long serialVersionUID = 1L;
	public NetworkException() {
		super();
	}
	public NetworkException(Exception e) {
		super(e);
	}
}
