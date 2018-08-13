package com.vigoss.wechat.base.cache;

import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.exception.WeixinException;

public interface CacheCreator<T extends Cacheable> {
	/**
	 * CacheKey
	 *
	 * @return
	 */
	public String key();

	/**
	 * 创建Cache
	 *
	 * @throws WeixinException
	 * @return 缓存对象
	 */
	public T create() throws WeixinException;
}
