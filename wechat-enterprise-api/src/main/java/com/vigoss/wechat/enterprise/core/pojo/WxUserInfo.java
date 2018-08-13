package com.vigoss.wechat.enterprise.core.pojo;

import java.io.Serializable;

/**
 * 用户信息类
 * 
 * @author 
 * @createTime 
 * @history  1.修改时间,修改;修改内容：
 * 
 */
public class WxUserInfo implements Serializable {

	private static final long serialVersionUID = -2237265181267264677L;
	private Module currentModule = null;
	private String openId;
	private ConnList user;
	
	/**
	 * 重置
	 */
	public void reset(){
		this.currentModule = null;
	}

	/**
	 * 获取属性：当前模块
	 * @return
	 */
	public Module getCurrentModule() {
		return currentModule;
	}

	/**
	 * 设置属性：当前模块 
	 * @param 
	 */
	public void setCurrentModule(Module currentModule) {
		this.currentModule = currentModule;
	}

	public ConnList getUser() {
		return user;
	}

	public void setUser(ConnList user) {
		this.user = user;
	}

	/**
	 * 获取属性：openId 
	 * @return
	 */
	public String getUserid() {
		return openId;
	}

	/**
	 * 设置属性：openId 
	 * @param 
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
}
