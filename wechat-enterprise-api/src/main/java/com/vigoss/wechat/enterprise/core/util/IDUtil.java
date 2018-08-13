package com.vigoss.wechat.enterprise.core.util;

import java.util.UUID;


public class IDUtil {
	
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString().replace("-", "").toUpperCase();
		return id;
	}
	
}
