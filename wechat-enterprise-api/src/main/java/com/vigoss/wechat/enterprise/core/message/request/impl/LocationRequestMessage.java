package com.vigoss.wechat.enterprise.core.message.request.impl;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;
import org.dom4j.Document;
import org.dom4j.Node;

import com.vigoss.wechat.enterprise.core.message.request.RequestMessage;

/**
 * 地理位置类型请求消息
 * 
 * @author 
 * @createTime 
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class LocationRequestMessage extends RequestMessage {

	private String locationX;
	private String locationY;
	private String scale;
	private String label;
	
	/**
	 * 构造方法
	 * @param accountid
	 * @param xmlDoc
	 */
	public LocationRequestMessage(String accountid,Document xmlDoc){
		super(accountid,xmlDoc);
		this.locationX = xmlDoc.selectSingleNode("/xml/Location_X").getText();
		this.locationY = xmlDoc.selectSingleNode("/xml/Location_Y").getText();
		this.scale = xmlDoc.selectSingleNode("/xml/Scale").getText();
		Node nd = xmlDoc.selectSingleNode("/xml/Label");
		if (nd != null){
			this.label = nd.getText();
		}
	}

	/**
	 * 获取属性：地理位置信息 
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 获取属性：地理位置纬度
	 * @return
	 */
	public String getLocationX() {
		return locationX;
	}

	/**
	 * 获取属性：地理位置经度
	 * @return
	 */
	public String getLocationY() {
		return locationY;
	}

	/**
	 * 获取属性：地图缩放大小 
	 * @return
	 */
	public String getScale() {
		return scale;
	}

	/**
	 * 转换为xml字符串
	 * @param out
	 */
	@Override
	protected void toString(StringBuilder out) {
		out.append("	<locationX>").append(this.locationX).append("</locationX>\n");
		out.append("	<locationY>").append(this.locationY).append("</locationY>\n");
		out.append("	<scale>").append(this.scale).append("</scale>\n");
		out.append("	<label>").append(this.label).append("</label>\n");
		
	}

}
