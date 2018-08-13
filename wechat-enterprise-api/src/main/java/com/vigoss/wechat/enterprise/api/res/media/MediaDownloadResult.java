package com.vigoss.wechat.enterprise.api.res.media;


import com.vigoss.wechat.base.http.ContentType;

import java.io.Serializable;

public class MediaDownloadResult implements Serializable {

	private static final long serialVersionUID = -7090523911701729058L;

	private byte[] content;

	private ContentType contentType;

	private String fileName;

	public byte[] getContent() {
		return content;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public String getFileName() {
		return fileName;
	}

	public MediaDownloadResult(byte[] content, ContentType contentType,
                               String fileName) {
		this.content = content;
		this.contentType = contentType;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "MediaDownloadResult [content=..., contentType=" + contentType
				+ ", fileName=" + fileName + "]";
	}
}
