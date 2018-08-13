package com.vigoss.wechat.enterprise.core.message.request.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;

/**
 * 链接类型的请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class LinkRequestMessage extends RequestMessage {

	private String title;
	private String description;
	private String url;
	
	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public LinkRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
		this.title = xmlDoc.selectSingleNode("/xml/Title").getText();
		this.url = xmlDoc.selectSingleNode("/xml/Url").getText();
		this.description = xmlDoc.selectSingleNode("/xml/Description").getText();
	}

	/**
	 * 获取属性： 描述 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 获取属性： 标题
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 获取属性： 链接
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append("	<title>").append(this.title).append("</title>\n");
		out.append("	<url>").append(this.url).append("</url>\n");
		out.append("	<desc>").append(this.description).append("</desc>\n");
	}
	
}
