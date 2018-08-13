package com.vigoss.wechat.base.http.support.apache3;

import java.io.IOException;

import com.vigoss.wechat.base.http.AbstractHttpResponse;
import com.vigoss.wechat.base.http.HttpHeaders;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;

import com.vigoss.wechat.base.http.AbstractHttpResponse;
import com.vigoss.wechat.base.http.HttpHeaders;
import com.vigoss.wechat.base.http.HttpStatus;
import com.vigoss.wechat.base.http.HttpVersion;

public class HttpComponent3Response extends AbstractHttpResponse {

	private final HttpMethod httpMethod;

	private HttpHeaders headers;
	private HttpVersion protocol;
	private HttpStatus status;

	public HttpComponent3Response(HttpMethod httpMethod) throws IOException {
		super(httpMethod.getResponseBody());
		this.httpMethod = httpMethod;
	}

	@Override
	public HttpHeaders getHeaders() {
		if (headers == null) {
			headers = new HttpHeaders();
			Header[] headers = httpMethod.getResponseHeaders();
			for (Header header : headers) {
				this.headers.add(header.getName(), header.getValue());
			}
		}
		return headers;
	}

	@Override
	public HttpVersion getProtocol() {
		org.apache.commons.httpclient.HttpVersion version = httpMethod
				.getParams().getVersion();
		if (version == null) {
			return null;
		}
		Header connection = httpMethod.getResponseHeader("Connection");
		if (protocol == null) {
			protocol = new HttpVersion("HTTP", version.getMajor(),
					version.getMinor(), connection != null
							&& KEEP_ALIVE.equalsIgnoreCase(connection
									.getValue()));
		}
		return protocol;
	}

	@Override
	public HttpStatus getStatus() {
		if (status == null) {
			status = new HttpStatus(httpMethod.getStatusCode(),
					httpMethod.getStatusText());
		}
		return status;
	}

	@Override
	public void close() {
		httpMethod.releaseConnection();
		//Protocol.unregisterProtocol("https");
	}
}
