package com.vigoss.wechat.base.http.support.okhttp;


import com.vigoss.wechat.base.http.AbstractHttpResponse;
import com.vigoss.wechat.base.http.HttpHeaders;
import com.vigoss.wechat.base.http.HttpStatus;
import com.vigoss.wechat.base.http.HttpVersion;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Response;
import com.vigoss.wechat.base.http.AbstractHttpResponse;

public class OkHttpResponse2 extends AbstractHttpResponse {
	private final Response response;
	private HttpHeaders headers;
	private HttpVersion protocol;
	private HttpStatus status;

	public OkHttpResponse2(Response response, byte[] content) {
		super(content);
		this.response = response;
	}

	@Override
	public HttpHeaders getHeaders() {
		if (this.headers == null) {
			this.headers = new HttpHeaders();
			Headers headers = this.response.headers();
			for (int i = 0; i < headers.size(); i++) {
				this.headers.add(headers.name(i), headers.value(i));
			}
		}
		return this.headers;
	}

	@Override
	public HttpVersion getProtocol() {
		if (protocol == null) {
			String protocol = this.response.protocol().toString().split("/")[0];
			boolean keepAlive = KEEP_ALIVE.equalsIgnoreCase(this.response
					.header("Connection"));
			if (this.response.protocol() == Protocol.HTTP_1_0) {
				return new HttpVersion(protocol, 1, 0, keepAlive);
			} else if (this.response.protocol() == Protocol.HTTP_1_1) {
				return new HttpVersion(protocol, 1, 1, keepAlive);
			} else if (this.response.protocol() == Protocol.HTTP_2) {
				return new HttpVersion(protocol, 2, 0, keepAlive);
			} else if (this.response.protocol() == Protocol.SPDY_3) {
				return new HttpVersion(protocol, 3, 0, keepAlive);
			} else {
				this.protocol = new HttpVersion(protocol, keepAlive);
			}
		}
		return protocol;
	}

	@Override
	public HttpStatus getStatus() {
		if (status == null) {
			status = new HttpStatus(this.response.code(),
					this.response.message());
		}
		return status;
	}

	@Override
	public void close() {
		// nothing
	}
}
