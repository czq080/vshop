package com.vigoss.wechat.enterprise.core.message.request.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import org.dom4j.Document;
import org.dom4j.Node;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;

/**
 * 语音类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class VoiceRequestMessage extends RequestMessage {

	private String recognition;
	private String mediaId;
	private String format;


	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public VoiceRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
		this.mediaId = xmlDoc.selectSingleNode("/xml/MediaId").getText();
		this.format = xmlDoc.selectSingleNode("/xml/Format").getText();
		Node node=xmlDoc.selectSingleNode("/xml/Recognition");
		if(node!=null)
			recognition=node.getText();
	}
	
	/**
	 * 获取属性：语音格式，如amr，speex
	 * @return
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 获取属性：语音媒体文件id
	 * @return
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 获取属性： 语音识别结果 
	 * @return
	 */
	public String getRecognition() {
		return recognition;
	}

	@Override
	protected void toString(StringBuilder out) {
		out.append("	<MediaId>").append(this.mediaId).append("</MediaId>\n");
		out.append("	<Format>").append(this.format).append("</Format>\n");
	}
}
