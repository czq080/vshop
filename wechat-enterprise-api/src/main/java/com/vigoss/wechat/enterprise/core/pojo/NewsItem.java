package com.vigoss.wechat.enterprise.core.pojo;


/**
 * 多图文类型消息的Item
 * 
 * @author lwgang
 * @createTime 2014-11-04
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class NewsItem {
	private String id;
	private String title;//标题
	private String description;//摘要
	private String picurl;//图片地址
	private String url;//跳转链接
	private String key;//关键字
	private String sort;//排序
	private int resets;
	
	private String chat_id;

	public NewsItem() {
	}

	public NewsItem(String title, String description, String picurl, String url) {
		this.title = title;
		this.description = description;
		this.picurl = picurl;
		this.url = url;
	}

	/**
	 * 获取属性：标题
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置属性： 标题
	 * 
	 * @param
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取属性：描述
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置属性： 描述
	 * 
	 * @param
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取属性：图文消息的图片链接
	 * 
	 * @return
	 */
	public String getPicurl() {
		return picurl;
	}

	/**
	 * 设置属性： 图文消息的图片链接
	 * 
	 * @param
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	/**
	 * 获取属性：点击后跳转的链接
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置属性： 点击后跳转的链接
	 * 
	 * @param
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getResets() {
		return resets;
	}
	public void setResets(int resets) {
		this.resets = resets;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getChat_id() {
		return chat_id;
	}

	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
	}
	
}
