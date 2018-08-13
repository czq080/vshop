package com.vigoss.wechat.enterprise.core.message.request.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import org.dom4j.Document;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;

/**
 * 图片类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class ImageRequestMessage extends RequestMessage {
	
	private String picUrl;
	private String mediaId;
	
	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public ImageRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
		this.picUrl = xmlDoc.selectSingleNode("/xml/PicUrl").getText();
		this.mediaId = xmlDoc.selectSingleNode("/xml/MediaId").getText();
	}

	/**
	 * 获取属性：图片链接 
	 * @return
	 */
	public String getPicUrl(){
		return this.picUrl;
	}

	/**
	 * 获取属性： 图片媒体文件id 
	 * @return
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append("	<picUrl>").append(this.picUrl).append("</picUrl>\n");
	}	
}
