package com.vigoss.wechat.enterprise.core.message.helper;

import java.util.ArrayList;
import java.util.List;

import com.vigoss.wechat.enterprise.core.message.impl.NewsResponseMessage;
import com.vigoss.wechat.enterprise.core.message.impl.TextResponseMessage;
import com.vigoss.wechat.enterprise.core.message.request.EventRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.*;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;
import com.vigoss.wechat.enterprise.core.pojo.ChatMsg;
import com.vigoss.wechat.enterprise.core.pojo.NewsItem;
import com.vigoss.wechat.enterprise.core.util.IDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vigoss.wechat.enterprise.core.message.impl.NewsResponseMessage;
import com.vigoss.wechat.enterprise.core.message.impl.TextResponseMessage;
import com.vigoss.wechat.enterprise.core.message.request.EventRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.ClickEventRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.ImageRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.LocationRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.ScanEventRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.SubscribeEventRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.TextRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.VideoRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.ViewEventRequestMessage;
import com.vigoss.wechat.enterprise.core.message.request.impl.VoiceRequestMessage;
import com.vigoss.wechat.enterprise.core.message.response.ResponseMessage;
import com.vigoss.wechat.enterprise.core.pojo.ChatMsg;
import com.vigoss.wechat.enterprise.core.pojo.NewsItem;
import com.vigoss.wechat.enterprise.core.util.IDUtil;

/**
 * 消息日志帮助类
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class MessageLogHelper {
	
	private static Logger log = LoggerFactory.getLogger(MessageLogHelper.class);
	
	/**
	 * 保存消息日志
	 * @param requestMessage
	 * @param responseMessage
	 */
	public static void saveMessage(final RequestMessage requestMessage, final ResponseMessage responseMessage){
		
		List<ChatMsg> msglist=new ArrayList<ChatMsg>();
		if (requestMessage != null) {
			ChatMsg msg=new ChatMsg();
			msg.setIsRequest("0");
			msg.setAccountId(requestMessage.getAccountId());
			msg.setCreateTime(requestMessage.getCreateTime());
			msg.setFromUserName(requestMessage.getFromUserName());
				
			msg.setMsgId(requestMessage.getMsgId());
			msg.setMsgType(requestMessage.getMsgType());			
			msg.setToUserName(requestMessage.getToUserName());
			if (requestMessage instanceof TextRequestMessage) {
				msg.setContent(requestMessage.getContent());	
			} else if (requestMessage instanceof ImageRequestMessage) {
				msg.setMediaId(((ImageRequestMessage)requestMessage).getMediaId());
				msg.setPicUrl(((ImageRequestMessage)requestMessage).getPicUrl());
			} else if (requestMessage instanceof VoiceRequestMessage) {
				msg.setRecognition(((VoiceRequestMessage) requestMessage).getRecognition());
				msg.setMediaId(((VoiceRequestMessage)requestMessage).getMediaId());
				msg.setFormat(((VoiceRequestMessage) requestMessage).getFormat());
			} else if (requestMessage instanceof VideoRequestMessage) {
				msg.setMediaId(((VideoRequestMessage) requestMessage).getMediaId());
				msg.setThumbmediaid(((VideoRequestMessage) requestMessage).getThumbMediaId());
			} else if (requestMessage instanceof LocationRequestMessage) {
				msg.setLocation_x(((LocationRequestMessage) requestMessage).getLocationX());
				msg.setLocation_y(((LocationRequestMessage) requestMessage).getLocationY());
				msg.setScale(((LocationRequestMessage) requestMessage).getScale());
				msg.setLabel(((LocationRequestMessage) requestMessage).getLabel());
			} else if (requestMessage instanceof SubscribeEventRequestMessage
					|| requestMessage instanceof ClickEventRequestMessage
					|| requestMessage instanceof ViewEventRequestMessage
					|| requestMessage instanceof ScanEventRequestMessage
				) {
				msg.setEvent(((EventRequestMessage)requestMessage).getEvent());
				msg.setEventkey(((EventRequestMessage)requestMessage).getEventKey());
			}
			msglist.add(msg);
		}
		
		if (responseMessage != null){
			ChatMsg msg=new ChatMsg();
			msg.setIsRequest("1");
			msg.setAccountId(responseMessage.getAccountId());
			msg.setCreateTime(responseMessage.getCreateTime());
			msg.setFromUserName(responseMessage.getFromUserName());
				
			msg.setMsgId(responseMessage.getMsgId());
			msg.setMsgType(responseMessage.getMsgType());			
			msg.setToUserName(responseMessage.getToUserName());
			if (responseMessage instanceof TextResponseMessage){
				msg.setContent(((TextResponseMessage)responseMessage).getContent());
			}else if (responseMessage instanceof NewsResponseMessage){
				for(Object data:responseMessage.getData()){
					NewsItem item=(NewsItem) data;
					item.setId(IDUtil.getUUID());
					msg.addNewsItem(item);
				}
			}
			msglist.add(msg);
		}
		
		
		MessageLogThreadPool.saveMessage(msglist);
	}
}
