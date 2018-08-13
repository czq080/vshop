package com.vigoss.shop.common.exception;

/**
 * 程序疏漏导致 -->未捕获异常接口异常
 */
public class UnCatchShopException extends ShopException {
	private static final long serialVersionUID = 1L;
	public UnCatchShopException() {
		super();
	}
	public UnCatchShopException(Exception e) {
		super(e);
	}
}
