package com.vigoss.wechat.base.http.factory;

import com.vigoss.wechat.base.http.HttpClient;
import com.vigoss.wechat.base.http.HttpParams;
import com.vigoss.wechat.base.http.SimpleHttpClient;
import com.vigoss.wechat.base.http.SimpleHttpClient;

/**
 * HttpURLConnection的简单实现
 * 
 * @className SimpleHttpClientFactory
 * @author jinyu(foxinmy@gmail.com)
 * @date 2015年8月12日
 * @since JDK 1.6
 * @see SimpleHttpClient
 */
public class SimpleHttpClientFactory extends HttpClientFactory {

	@Override
	public HttpClient newInstance(HttpParams params) {
		return new SimpleHttpClient(params);
	}
}
