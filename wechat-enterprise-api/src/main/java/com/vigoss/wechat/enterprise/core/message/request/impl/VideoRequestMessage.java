package com.vigoss.wechat.enterprise.core.message.request.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;

/**
 * 视频类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class VideoRequestMessage extends RequestMessage {

	private String mediaId;
	private String thumbMediaId;
	
	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public VideoRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
		this.mediaId = xmlDoc.selectSingleNode("/xml/MediaId").getText();
		this.thumbMediaId = xmlDoc.selectSingleNode("/xml/ThumbMediaId").getText();
	}

	/**
	 * 获取属性：视频媒体文件id
	 * @return
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 获取属性： 视频消息缩略图的媒体id 
	 * @return
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	
	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append("	<MediaId>").append(this.mediaId).append("</MediaId>\n");
		out.append("	<ThumbMediaId>").append(this.thumbMediaId).append("</ThumbMediaId>\n");
	}

}
