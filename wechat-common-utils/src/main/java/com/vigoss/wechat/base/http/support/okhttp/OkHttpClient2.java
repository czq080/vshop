package com.vigoss.wechat.base.http.support.okhttp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map.Entry;

import com.vigoss.wechat.base.util.StringUtil;
import com.vigoss.wechat.base.http.AbstractHttpClient;
import com.vigoss.wechat.base.http.entity.HttpEntity;
import okio.BufferedSink;

import com.vigoss.wechat.base.http.AbstractHttpClient;
import com.vigoss.wechat.base.http.HttpClientException;
import com.vigoss.wechat.base.http.HttpHeaders;
import com.vigoss.wechat.base.http.HttpMethod;
import com.vigoss.wechat.base.http.HttpRequest;
import com.vigoss.wechat.base.http.HttpResponse;
import com.vigoss.wechat.base.http.entity.HttpEntity;
import com.vigoss.wechat.base.util.StringUtil;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class OkHttpClient2 extends AbstractHttpClient {
	private final OkHttpClient okClient;

	public OkHttpClient2(OkHttpClient okClient) {
		this.okClient = okClient;
	}

	@Override
	public HttpResponse execute(HttpRequest request) throws HttpClientException {
		HttpResponse response = null;
		try {
			Request okRequest = createRequest(request);
			Response okResponse = okClient.newCall(okRequest).execute();
			response = new OkHttpResponse2(okResponse, okResponse.body()
					.bytes());
			handleResponse(response);
		} catch (IOException e) {
			throw new HttpClientException("I/O error on "
					+ request.getMethod().name() + " request for \""
					+ request.getURI().toString(), e);
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return response;
	}

	/**
	 * create OkRequest
	 */
	protected Request createRequest(HttpRequest request)
			throws HttpClientException {
		Request.Builder requestBuilder = createBuilder(request);
		resolveHeaders(request.getHeaders(), requestBuilder);
		resolveContent(request.getEntity(), request.getMethod(), requestBuilder);
		return requestBuilder.build();
	}

	/**
	 * create Request.Builder
	 * 
	 * @throws HttpClientException
	 */
	protected Request.Builder createBuilder(HttpRequest request)
			throws HttpClientException {
		Request.Builder requestBuilder = new Request.Builder();
		try {
			requestBuilder.url(request.getURI().toURL());
		} catch (MalformedURLException e) {
			throw new HttpClientException("format URI error", e);
		}
		return requestBuilder;
	}

	/**
	 * resolve Request.Headers
	 * */
	protected void resolveHeaders(
			com.vigoss.wechat.base.http.HttpHeaders headers,
			Request.Builder requestBuilder) {
		if (headers == null) {
			headers = new HttpHeaders();
		}
		// Add default accept headers
		if (!headers.containsKey(HttpHeaders.ACCEPT)) {
			headers.set(HttpHeaders.ACCEPT, "*/*");
		}
		// Add default user agent
		if (!headers.containsKey(HttpHeaders.USER_AGENT)) {
			headers.set(HttpHeaders.USER_AGENT, "square/okhttp2");
		}
		for (Entry<String, List<String>> header : headers.entrySet()) {
			if (HttpHeaders.COOKIE.equalsIgnoreCase(header.getKey())) {
				requestBuilder.header(header.getKey(),
						StringUtil.join(header.getValue(), ';'));
			} else {
				for (String headerValue : header.getValue()) {
					requestBuilder.header(header.getKey(),
							headerValue != null ? headerValue : "");
				}
			}
		}
	}

	/**
	 * resolve Request.Content
	 */
	protected void resolveContent(final HttpEntity entity, HttpMethod method,
                                  Request.Builder requestBuilder) throws HttpClientException {
		RequestBody body = null;
		if (entity != null) {
			body = new RequestBody() {

				@Override
				public long contentLength() throws IOException {
					return entity.getContentLength();
				}

				@Override
				public void writeTo(BufferedSink sink) throws IOException {
					entity.writeTo(sink.outputStream());
				}

				@Override
				public MediaType contentType() {
					return MediaType.parse(entity.getContentType().toString());
				}
			};
		}
		requestBuilder.method(method.name(), body);
	}
}