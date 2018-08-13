package com.vigoss.wechat.enterprise.core.message.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;
import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;

/**
 * 文本类型响应消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class TextResponseMessage extends ResponseMessage {
	
	private String content;
	
	/**
	 * 构造方法
	 * @param toUserName
	 * @param fromUserName
	 * @param accountid
	 */
	public TextResponseMessage(String toUserName,String fromUserName,String accountid){
		super(toUserName, fromUserName, accountid);
	}
	
	/**
	 * 构造方法
	 * @param requestMessage
	 */
	public TextResponseMessage(RequestMessage requestMessage){
		super(requestMessage);
	}
	
	/**
	 * 获取属性：文本消息内容
	 * @return
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置属性：文本消息内容
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取响应消息类型
	 */
	@Override
	public String getMsgType() {
		return "text";
	}
	
	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append(" <Content><![CDATA[").append(content).append("]]></Content>");
	}	
}
