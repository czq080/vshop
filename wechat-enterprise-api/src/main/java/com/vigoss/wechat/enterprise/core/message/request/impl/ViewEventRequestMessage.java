package com.vigoss.wechat.enterprise.core.message.request.impl;

import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.EventRequestMessage;

/**
 * 点击菜单跳转链接事件类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class ViewEventRequestMessage extends EventRequestMessage{	
	
	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public ViewEventRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);	
	}	
}
