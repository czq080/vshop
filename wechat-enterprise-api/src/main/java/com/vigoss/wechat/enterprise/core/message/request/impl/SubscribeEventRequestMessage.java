package com.vigoss.wechat.enterprise.core.message.request.impl;

import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.EventRequestMessage;

/**
 * 关注事件类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class SubscribeEventRequestMessage extends EventRequestMessage{	

	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public SubscribeEventRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
	}
	
	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append("	<Event>").append(this.event).append("</Event>\n");
	}	
}
