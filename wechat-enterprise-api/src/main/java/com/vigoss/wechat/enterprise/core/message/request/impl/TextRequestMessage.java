package com.vigoss.wechat.enterprise.core.message.request.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;


/**
 * 文本类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class TextRequestMessage extends RequestMessage {

	
	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public TextRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
		this.content = xmlDoc.selectSingleNode("/xml/Content").getText();
	}


	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append("	<Content>").append(this.content).append("</Content>\n");
	}

}
