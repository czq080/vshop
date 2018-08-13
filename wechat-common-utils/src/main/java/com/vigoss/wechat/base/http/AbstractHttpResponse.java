package com.vigoss.wechat.base.http;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public abstract class AbstractHttpResponse implements HttpResponse {
	protected final static String KEEP_ALIVE = "keep-alive";
	private final byte[] content;

	public AbstractHttpResponse(byte[] content) {
		this.content = content;
	}

	@Override
	public byte[] getContent() {
		return content;
	}

	@Override
	public InputStream getBody() {
		return content != null ? new ByteArrayInputStream(content) : null;
	}
}
