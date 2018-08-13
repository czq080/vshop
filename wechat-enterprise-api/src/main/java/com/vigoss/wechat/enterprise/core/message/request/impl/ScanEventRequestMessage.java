package com.vigoss.wechat.enterprise.core.message.request.impl;

import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.EventRequestMessage;

public class ScanEventRequestMessage extends EventRequestMessage{

	public ScanEventRequestMessage(String account_id, Document xmlDoc) {
		super(account_id, xmlDoc);
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
