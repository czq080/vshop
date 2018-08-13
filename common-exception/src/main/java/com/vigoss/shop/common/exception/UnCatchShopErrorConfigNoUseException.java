package com.vigoss.shop.common.exception;

/**
 * 程序疏漏导致 -->未捕获异常接口异常
 *   因为是没有获取配置的，所以不继承ExtraException
 */
public class UnCatchShopErrorConfigNoUseException {
	private static final long serialVersionUID = 1L;

	private String respCode="P003";
	private String exceptionMsg="{\"ZH\":\"抱歉，系统繁忙，请稍后重试\",\"EN\":\"Sorry, system busy，please try again later\"}";
	//不序列化 ，展示不传输给外部
	private transient String devMsg="程序最终返回异常码为空，未捕获的异常(此码直接在代码中定义程序，无直接使用此项配置)";


	public String getRespCode() {
		return respCode;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}


	public String getDevMsg() {
		return devMsg;
	}

}
