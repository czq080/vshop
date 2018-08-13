package com.vigoss.wechat.base.util;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

public class NameValue implements Serializable {

	private static final long serialVersionUID = -348620146718819093L;
	private String name;
	private String value;

	@JSONCreator
	public NameValue(@JSONField(name = "name") String name,
			@JSONField(name = "value") String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "NameValue [name=" + name + ", value=" + value + "]";
	}
}
