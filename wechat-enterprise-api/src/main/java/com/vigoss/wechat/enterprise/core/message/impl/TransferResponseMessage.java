package com.vigoss.wechat.enterprise.core.message.impl;

import java.util.List;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;
import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;

/**
 * 多客服回复
 * @author lhyan3
 * 2015年5月19日下午3:45:18
 */
public class TransferResponseMessage extends ResponseMessage {
	
	public TransferResponseMessage(RequestMessage requestMessage) {
		super(requestMessage);
	}

	@Override
	public String getMsgType() {
		return "transfer_customer_service";
	}
	
	@Override
	protected void toString(StringBuilder out) {
		List<Object> data=getData();
		if(data!=null && data.size()>0){
			Object object = data.get(0);
			out.append("<TransInfo>\n");
			out.append(" <KfAccount><![CDATA["+object.toString()+"]]></KfAccount>\n");
			out.append("</TransInfo>\n");
		}
	}

}
