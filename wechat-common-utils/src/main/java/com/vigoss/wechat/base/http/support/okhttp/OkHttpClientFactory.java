package com.vigoss.wechat.base.http.support.okhttp;

import com.vigoss.wechat.base.http.HttpClient;
import com.vigoss.wechat.base.http.HttpParams;
import com.vigoss.wechat.base.http.factory.HttpClientFactory;
import com.vigoss.wechat.base.http.factory.HttpClientFactory;

public class OkHttpClientFactory extends HttpClientFactory {
	private static HttpClientFactory okHttpClientFactory;
	static {
		try {
			okHttpClientFactory = new OkHttpClient3Factory();
		} catch (Throwable e1) {
			try {
				okHttpClientFactory = new OkHttpClient2Factory();
			} catch (Throwable e2) {
				throw new RuntimeException(e2);
			}
		}
	}

	@Override
	public HttpClient newInstance(HttpParams params) {
		return okHttpClientFactory.newInstance(params);
	}
}
