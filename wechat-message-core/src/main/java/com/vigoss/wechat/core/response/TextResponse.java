package com.vigoss.wechat.core.response;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class TextResponse implements MessageResponse {

	/**
	 * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	private String content;

	public TextResponse(String content) {
		this.content = content;
	}

	@Override
	public String content() {
		return String.format("<Content><![CDATA[%s]]></Content>", content);
	}

	@Override
	public String msgType() {
		return "text";
	}

	public String getContent() {
		return content;
	}
}
