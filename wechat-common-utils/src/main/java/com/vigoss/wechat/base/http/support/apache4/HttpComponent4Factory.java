package com.vigoss.wechat.base.http.support.apache4;

import com.vigoss.wechat.base.http.factory.HttpClientFactory;
import org.apache.http.util.VersionInfo;

import com.vigoss.wechat.base.http.HttpClient;
import com.vigoss.wechat.base.http.HttpParams;
import com.vigoss.wechat.base.http.factory.HttpClientFactory;

public class HttpComponent4Factory extends HttpClientFactory {

	private static HttpClientFactory httpComponentFactory;
	static {
		VersionInfo version = VersionInfo.loadVersionInfo(
				"org.apache.http.client", HttpClient.class.getClassLoader());
		String release = (version != null) ? version.getRelease()
				: VersionInfo.UNAVAILABLE;
		if (release.startsWith("4.")) {
			if (release.startsWith("4.0") || release.startsWith("4.1")
					|| release.startsWith("4.2")) {
				httpComponentFactory = new HttpComponent4_1Factory();
			} else {
				httpComponentFactory = new HttpComponent4_2Factory();
			}
		} else {
			throw new RuntimeException("unknown the HttpComponent version:"
					+ release);
		}
	}

	@Override
	public HttpClient newInstance(HttpParams params) {
		return httpComponentFactory.newInstance(params);
	}
}
