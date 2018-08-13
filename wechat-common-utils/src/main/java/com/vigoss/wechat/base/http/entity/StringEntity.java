package com.vigoss.wechat.base.http.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.http.ContentType;
import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.http.ContentType;

public class StringEntity implements HttpEntity {

	private final byte[]      content;
	private final ContentType contentType;

	public StringEntity(String body) {
		this(body, ContentType.DEFAULT_TEXT);
	}

	public StringEntity(String body, ContentType contentType) {
		this.content = body.getBytes(contentType.getCharset());
		this.contentType = contentType;
	}

	@Override
	public ContentType getContentType() {
		return contentType;
	}

	@Override
	public long getContentLength() {
		return this.content.length;
	}

	@Override
	public InputStream getContent() throws IOException {
		return new ByteArrayInputStream(this.content);
	}

	@Override
	public void writeTo(OutputStream outstream) throws IOException {
		outstream.write(this.content);
		outstream.flush();
	}


	public String getContentString() {
		return new String(this.content, Consts.UTF_8);
	}

}
