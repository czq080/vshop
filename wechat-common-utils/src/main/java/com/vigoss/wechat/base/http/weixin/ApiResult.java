package com.vigoss.wechat.base.http.weixin;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.alibaba.fastjson.annotation.JSONField;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ApiResult implements Serializable {

	private static final long serialVersionUID = -6185313616955051150L;

	/**
	 * 调用接口返回码，通信标识
	 */
	@XmlElement(name = "return_code")
	@JSONField(name = "errcode")
	private String returnCode;

	/**
	 * 调用接口返回消息,如非 空,为错误原因 可能为空
	 */
	@XmlElement(name = "return_msg")
	@JSONField(name = "errmsg")
	private String returnMsg;

	public ApiResult() {
		this.returnCode = "0";
		this.returnMsg = "OK";
	}

	public ApiResult(String returnCode, String returnMsg) {
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	@Override
	public String toString() {
		return "returnCode=" + returnCode + ", returnMsg=" + returnMsg;
	}
}
