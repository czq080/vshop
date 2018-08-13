package com.vigoss.wechat.base.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.vigoss.wechat.base.http.ContentType;
import com.vigoss.wechat.base.http.ContentType;

public interface HttpEntity {
	
	ContentType getContentType();

	long getContentLength();

	InputStream getContent() throws IOException;

	void writeTo(OutputStream outstream) throws IOException;
}
