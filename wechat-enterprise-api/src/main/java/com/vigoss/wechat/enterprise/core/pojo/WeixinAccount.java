package com.vigoss.wechat.enterprise.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信服务号对象
 * 
 * @author lwgang
 * @createTime 2015-01-22
 * @history 1.修改时间,修改;修改内容：
 * 
 */
public class WeixinAccount implements Serializable {

	private static final long serialVersionUID = -3783293808632853486L;

	private String id;
	private String appid;//应用id
	private String appsecret;//应用密钥
	private String name;//服务号名称
	private String authdomain;//应用域名
	private String url;//回调URL
	private String token;//令牌
	private String aeskey;//密钥
	private String picurl;//应用图片
	private Integer enable;//启用标志
	private String creator;//创建者
	private Date createtime;//创建时间
	private String userid;//用户账号
	private String server_context;//访问工程名

	public WeixinAccount() {
		this.createtime = new Date();
	}
	
	public WeixinAccount(String id,String appid,String appsecret,String name, String authdomain, String url,
			String token, String aeskey, String picurl,Integer enable, String creator) {
		this.id = id;
		this.appid = appid;
		this.appsecret = appsecret;
		this.name = name;
		this.authdomain = authdomain;
		this.url = url;
		this.token = token;
		this.aeskey = aeskey;
		this.picurl = picurl;
		this.enable = enable;
		this.creator = creator;
		this.createtime = new Date();
	}
	
	
	/**
	 * 设置属性：唯一标识
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取属性：唯一标识
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置属性：应用ID
	 * @param appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * 获取属性：应用ID
	 * @return
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * 设置属性：应用秘钥
	 * @param appsecret
	 */
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	/**
	 * 获取属性：应用秘钥
	 * @return
	 */
	public String getAppsecret() {
		return appsecret;
	}

	/**
	 * 获取属性：应用名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置属性：应用名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 设置属性：授权域名
	 * 
	 * @param
	 */
	public void setAuthdomain(String authdomain) {
		this.authdomain = authdomain;
	}

	/**
	 * 获取属性：授权域名
	 * 
	 * @return
	 */
	public String getAuthdomain() {
		return authdomain;
	}

	/**
	 * 设置属性：回调URL
	 * 
	 * @param
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取属性：回调URL
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置属性：令牌
	 * 
	 * @param
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 获取属性：令牌
	 * 
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 设置属性：密钥
	 * 
	 * @param
	 */
	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}

	/**
	 * 获取属性：密钥
	 * 
	 * @return
	 */
	public String getAeskey() {
		return aeskey;
	}

	/**
	 * 设置属性：应用图片URL
	 * 
	 * @param
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	/**
	 * 获取属性：应用图片URL
	 * 
	 * @return
	 */
	public String getPicurl() {
		return picurl;
	}

	/**
	 * 设置属性：启用标志
	 * 
	 * @param
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	/**
	 * 获取属性：启用标志
	 * 
	 * @return
	 */
	public Integer getEnable() {
		return enable;
	}

	/**
	 * 设置属性：创建者
	 * 
	 * @param
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 获取属性：创建者
	 * 
	 * @return
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * 设置属性：创建时间
	 * 
	 * @param
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取属性：创建时间
	 * 
	 * @return
	 */
	public Date getCreatetime() {
		return createtime;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getServer_context() {
		return server_context;
	}

	public void setServer_context(String server_context) {
		this.server_context = server_context;
	}
	
	
}
