package com.vigoss.wechat.base.http;

import java.io.InputStream;

public interface HttpResponse extends HttpMessage {
	/**
	 * HTTP协议
	 * 
	 * @return
	 */
	HttpVersion getProtocol();

	/**
	 * 响应状态
	 * 
	 * @return
	 */
	HttpStatus getStatus();
	/**
	 * 响应内容
	 * 
	 * @return
	 */
	InputStream getBody();

	/**
	 * 响应内容
	 * 
	 * @return
	 */
	byte[] getContent();

	/**
	 * 释放资源
	 */
	void close();
}
