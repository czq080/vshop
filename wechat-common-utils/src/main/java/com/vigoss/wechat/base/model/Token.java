package com.vigoss.wechat.base.model;

import com.vigoss.wechat.base.cache.Cacheable;
import com.vigoss.wechat.base.cache.Cacheable;

import java.util.HashMap;
import java.util.Map;

public class Token implements Cacheable {

	private static final long serialVersionUID = -7564855472419104084L;

	/**
	 * 获取到的凭证
	 */
	private String accessToken;
	/**
	 * 凭证有效时间，单位：毫秒
	 */
	private long expires;
	/**
	 * token创建的时间,单位：毫秒
	 */
	private long createTime;
	/**
	 * 扩展信息
	 */
	private Map<String, String> extra;

	/**
	 * 永不过期、创建时间为当前时间戳的token对象
	 *
	 * @param accessToken
	 *            凭证字符串
	 */
	public Token(String accessToken) {
		this(accessToken, -1);
	}

	/**
	 * 有过期时间、创建时间为当前时间戳的token对象
	 *
	 * @param accessToken
	 *            凭证字符串
	 * @param expires
	 *            过期时间 单位毫秒
	 */
	public Token(String accessToken, long expires) {
		this(accessToken, expires, System.currentTimeMillis());
	}

	/**
	 *
	 * @param accessToken
	 *            凭证字符串
	 * @param expires
	 *            过期时间 单位毫秒
	 * @param createTime
	 *            创建时间戳 单位毫秒
	 */
	public Token(String accessToken, long expires, long createTime) {
		this.accessToken = accessToken;
		this.expires = expires;
		this.createTime = createTime;
		this.extra = new HashMap<>();
	}

	public String getAccessToken() {
		return accessToken;
	}

	@Override
	public long getExpires() {
		return expires;
	}

	@Override
	public long getCreateTime() {
		return createTime;
	}

	public Map<String, String> getExtra() {
		return extra;
	}

	public Token pushExtra(String name, String value) {
		this.extra.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Token [accessToken=" + accessToken + ", expires=" + expires
				+ ", createTime=" + createTime + ", extra=" + extra + "]";
	}
}
