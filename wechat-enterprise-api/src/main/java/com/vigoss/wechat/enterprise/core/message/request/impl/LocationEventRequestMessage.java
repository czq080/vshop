package com.vigoss.wechat.enterprise.core.message.request.impl;

import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.EventRequestMessage;


public class LocationEventRequestMessage extends EventRequestMessage{

	public LocationEventRequestMessage(String account_id, Document xmlDoc) {
		super(account_id, xmlDoc);
	}
	
}
