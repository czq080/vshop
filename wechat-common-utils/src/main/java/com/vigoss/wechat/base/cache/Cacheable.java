package com.vigoss.wechat.base.cache;

import java.io.Serializable;

public interface Cacheable extends Serializable {
	/**
	 * 过期时间(单位:毫秒),值小于0时视为永不过期
	 *
	 * @return 缓存过期时间
	 */
	public long getExpires();

	/**
	 * 创建时间(单位:毫秒)
	 *
	 * @return 缓存对象创建时间
	 */
	public long getCreateTime();
}
