package com.vigoss.wechat.enterprise.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 政务微信企业应用对象
 * @author sakuragi_xwshan
 *
 */
public class Agent implements Serializable{

private static final long serialVersionUID = -3783293808632853486L;
	
	private Integer agentid;
	private String name;
	private String token;
	private String aeskey;
	private Date createtime;

	/**
	 * 设置属性：应用ID
	 * @param 
	 */
	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	/**
	 * 获取属性：应用ID
	 * @return
	 */
	public Integer getAgentid() {
		return agentid;
	}
	
	/**
	 * 获取属性：应用名称 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 设置属性：应用名称 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 设置属性：令牌
	 * @param 
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 获取属性：令牌
	 * @return
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 设置属性：密钥
	 * @param 
	 */
	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}

	/**
	 * 获取属性：密钥
	 * @return
	 */
	public String getAeskey() {
		return aeskey;
	}

	/**
	 * 设置属性：创建时间
	 * @param 
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取属性：创建时间
	 * @return
	 */
	public Date getCreatetime() {
		return createtime;
	}
	
}
