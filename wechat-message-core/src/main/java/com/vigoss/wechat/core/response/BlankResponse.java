package com.vigoss.wechat.core.response;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class BlankResponse implements MessageResponse {

	@Override
	public String content() {
		return "success";
	}

	@Override
	public String msgType() {
		return "single";
	}
}
