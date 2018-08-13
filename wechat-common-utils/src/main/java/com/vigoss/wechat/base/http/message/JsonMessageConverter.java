package com.vigoss.wechat.base.http.message;

import java.io.IOException;
import java.io.InputStream;

import com.alibaba.fastjson.JSON;
import com.vigoss.wechat.base.util.FileUtil;
import com.vigoss.wechat.base.http.HttpHeaders;
import com.vigoss.wechat.base.http.HttpResponse;
import com.vigoss.wechat.base.http.MimeType;
import com.vigoss.wechat.base.util.FileUtil;
import com.vigoss.wechat.base.util.IOUtil;
import com.vigoss.wechat.base.util.RegexUtil;
import com.vigoss.wechat.base.util.RegexUtil;

/**
 * JSON 转换
 * 
 * @className JsonMessageConverter
 * @author jinyu
 * @date Jul 20, 2016
 * @since JDK 1.6
 */
public class JsonMessageConverter extends AbstractMessageConverter {

	public static final JsonMessageConverter GLOBAL = new JsonMessageConverter();

	private static final String JSO = "json";
	private static final int BRACE = 1 << '{';
	private static final int BRACKET = 1 << '[';
	private static final int MASK = BRACE | BRACKET;

	public JsonMessageConverter() {
		super(MimeType.APPLICATION_JSON, MimeType.TEXT_JSON, new MimeType(
				"application", "*+json"));
	}

	@Override
	public boolean canConvert(Class<?> clazz, HttpResponse response) {
		if (!super.canConvert(clazz, response)) {
			String disposition = response.getHeaders().getFirst(
					HttpHeaders.CONTENT_DISPOSITION);
			String fileName = RegexUtil
					.regexFileNameFromContentDispositionHeader(disposition);
			return (fileName != null && FileUtil.getFileExtension(fileName)
					.equalsIgnoreCase(JSO));
		}
		return true;
	}

	@Override
	protected boolean supports(Class<?> clazz, byte[] content) {
		return (MASK & (1 << content[0])) != 0;
	}

	@Override
	protected <T> T convertInternal(Class<? extends T> clazz, InputStream body)
			throws IOException {
		byte[] bytes = IOUtil.toByteArray(body);
		return JSON.parseObject(bytes, 0, bytes.length, charset.newDecoder(),
				clazz);
	}
}
