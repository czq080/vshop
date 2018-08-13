package com.vigoss.wechat.enterprise.core.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vigoss.wechat.enterprise.core.util.IDUtil;
import com.vigoss.wechat.enterprise.core.util.IDUtil;

public class ChatMsg {


	private String id=IDUtil.getUUID();
	
	private String toUserName;//接受者
	private String fromUserName;//发送者
	private String msgId;//消息ID
	private String msgType;//消息类型
	private String accountId;//服务号
	private String PicUrl;//图片URl
	private String MediaId;//多媒体ID
	private String content;//文本内容
	
	private Date createTime=new Date();
	private String format;//语音等格式
	private String recognition;//
	private String location_x;//地理位置维度
	private String location_y;//地理位置经度
	private String scale;//地图缩放大小
	private String label;//地理位置信息
	private String thumbmediaid;//视频消息缩略图的媒体id
	private String titile;//标题
	private String description;//描述
	private String url;//消息链接
	private String event;//事件类型，subscribe(订阅)、unsubscribe(取消订阅)
	private String eventkey;//事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String ticket;//二维码的ticket，可用来换取二维码图片
	private String isRequest;//是请求，还是回应 0：请求，1：回应
	private List<NewsItem> newsList=new ArrayList<NewsItem>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRecognition() {
		return recognition;
	}
	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}
	public String getLocation_x() {
		return location_x;
	}
	public void setLocation_x(String location_x) {
		this.location_x = location_x;
	}
	public String getLocation_y() {
		return location_y;
	}
	public void setLocation_y(String location_y) {
		this.location_y = location_y;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getThumbmediaid() {
		return thumbmediaid;
	}
	public void setThumbmediaid(String thumbmediaid) {
		this.thumbmediaid = thumbmediaid;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventkey() {
		return eventkey;
	}
	public void setEventkey(String eventkey) {
		this.eventkey = eventkey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public List<NewsItem> getNewsList() {
		return newsList;
	}
	public void addNewsItem(NewsItem item) {
		item.setChat_id(this.id);
		newsList.add(item);
	}
	public String getIsRequest() {
		return isRequest;
	}
	public void setIsRequest(String isRequest) {
		this.isRequest = isRequest;
	}

}
