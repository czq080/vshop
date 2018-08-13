package com.vigoss.wechat.enterprise.core.util;

import java.util.HashMap;

/**
 * 数据字典类
 * 
 * @author 
 * @createTime 
 * @history  1.修改时间,修改;修改内容：
 * 
 */
public class DataDicUtil {

	private static HashMap<String, String> channelIdxDesc;

	public static HashMap<String, String> getChannelIdxDesc() {
		return channelIdxDesc;
	}

	public static void setChannelIdxDesc(HashMap<String, String> channelIdxDesc) {
		DataDicUtil.channelIdxDesc = channelIdxDesc;
	}

	public static String getChannelIdxDescByKey(String key) {
		if (channelIdxDesc != null && channelIdxDesc.containsKey(key)) {
			return channelIdxDesc.get(key);
		}
		return null;
	}
	
	public static boolean doField(String str){
		if(str.indexOf("<")==-1&&str.indexOf(">")==-1&&str.indexOf("script")==-1&&str.indexOf("style")==-1){
			return true;
		}
		return false;
	}

	
}
