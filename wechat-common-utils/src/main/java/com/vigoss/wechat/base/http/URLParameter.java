package com.vigoss.wechat.base.http;

import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.util.URLEncodingUtil;
import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.util.NameValue;
import com.vigoss.wechat.base.util.URLEncodingUtil;
import com.vigoss.wechat.base.util.Consts;
import com.vigoss.wechat.base.util.NameValue;
import com.vigoss.wechat.base.util.URLEncodingUtil;

public class URLParameter extends NameValue {

	private static final long serialVersionUID = -115491642760990655L;

	public URLParameter(String name, String value) {
		super(name, value);
	}

	public String encoding() {
		return String.format("%s=%s",
				URLEncodingUtil.encoding(getName(), Consts.UTF_8, true),
				URLEncodingUtil.encoding(getValue(), Consts.UTF_8, true));
	}

	@Override
	public String toString() {
		return String.format("[URLParameter name=%s, value=%s]", getName(),
				getValue());
	}
}
