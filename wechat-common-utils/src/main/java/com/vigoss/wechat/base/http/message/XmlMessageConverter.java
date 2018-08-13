package com.vigoss.wechat.base.http.message;

import java.io.IOException;
import java.io.InputStream;

import com.vigoss.wechat.base.util.FileUtil;
import com.vigoss.wechat.base.http.HttpHeaders;
import com.vigoss.wechat.base.http.HttpResponse;
import com.vigoss.wechat.base.http.MimeType;
import com.vigoss.wechat.base.util.FileUtil;
import com.vigoss.wechat.base.util.RegexUtil;
import com.vigoss.wechat.base.xml.XmlStream;
import com.vigoss.wechat.base.util.RegexUtil;
import com.vigoss.wechat.base.xml.XmlStream;

/**
 * XML 转换
 * 
 * @className XmlMessageConverter
 * @author jinyu
 * @date Jul 20, 2016
 * @since JDK 1.6
 */
public class XmlMessageConverter extends AbstractMessageConverter {

	public static final XmlMessageConverter GLOBAL = new XmlMessageConverter();

	private static final String XML = "xml";
	private static final int BRACKET = '<';

	public XmlMessageConverter() {
		super(MimeType.APPLICATION_XML, MimeType.TEXT_XML, new MimeType("application", "*+xml"));
	}
	
	@Override
	public boolean canConvert(Class<?> clazz, HttpResponse response) {
		if (!super.canConvert(clazz, response)) {
			String disposition = response.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION);
			String fileName = RegexUtil.regexFileNameFromContentDispositionHeader(disposition);
			return (fileName != null && FileUtil.getFileExtension(fileName).equalsIgnoreCase(XML));
		}
		return true;
	}

	@Override
	protected boolean supports(Class<?> clazz, byte[] content) {
		return BRACKET == content[0];
	}

	@Override
	protected <T> T convertInternal(Class<? extends T> clazz, InputStream body) throws IOException {
		return XmlStream.fromXML(body, clazz);
	}
}
