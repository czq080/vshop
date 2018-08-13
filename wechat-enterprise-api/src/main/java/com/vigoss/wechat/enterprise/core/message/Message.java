package com.vigoss.wechat.enterprise.core.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 消息抽象类
 * 
 * @author 
 * @createTime  
 * @history  1.修改时间,修改;修改内容：
 * 
 */
public abstract class Message {
	
	private String id;
	
	protected String toUserName;
	protected String fromUserName;
	protected String msgId;
	protected String msgType;
	protected String accountId;
	protected String PicUrl;
	protected String MediaId;
	protected String content;
	protected String agentId; 
	private Date createTime=new Date();
	
	private List<Object> data;

	/**
	 * 获取属性：消息渠道 1：表示请求信息(用户发送) 0：表示响应信息(企业号响应) 
	 * @return
	 */
	protected abstract int getUserSend();
	

	/**
	 * 获取属性：唯一标示 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置属性：唯一标示 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 设置属性：服务号ID
	 * @param accountid
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * 获取属性：服务号ID
	 * 
	 * @return
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * 获取属性：消息创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 新增data数据
	 * @param obj
	 */
	public void addData(Object obj){
		if(data==null)
			data=new ArrayList<Object>();
		data.add(obj);
	}

	/**
	 * 获取data数据
	 * @return
	 */
	public List<Object> getData() {
		return data;
	}

	/**
	 * 获取属性：请求信息时表示服务号AppID，响应信息时表示员工UserID
	 * @return
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * 设置属性：请求信息时表示员工UserID，响应信息时表示服务号AppID
	 * @param fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * 获取属性：消息id
	 * @return
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * 获取属性：消息类型
	 * @return
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * 获取属性：图片路径
	 * @return
	 */
	public String getPicUrl() {
		return PicUrl;
	}

	/**
	 * 获取属性：媒体ID
	 * @return
	 */
	public String getMediaId() {
		return MediaId;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 内容
	 * lhyan3
	 * 2015年3月28日下午2:30:39
	 * TODO
	 * @return
	 */
	public String getContent() {
		return content;
	}


	public String getAgentId() {
		return agentId;
	}


	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}



	
	
}
