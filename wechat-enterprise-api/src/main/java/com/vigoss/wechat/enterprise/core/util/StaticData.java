package com.vigoss.wechat.enterprise.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vigoss.wechat.enterprise.core.pojo.DataDir;
import com.vigoss.wechat.enterprise.core.pojo.SysConf;
import com.vigoss.wechat.enterprise.core.pojo.WeixinAccount;
import com.vigoss.wechat.enterprise.core.pojo.DataDir;
import com.vigoss.wechat.enterprise.core.pojo.SysConf;
import com.vigoss.wechat.enterprise.core.pojo.WeixinAccount;

public class StaticData {

	private static Map<String, String> sysconfMap = new HashMap<String, String>();
	private static Map<String, WeixinAccount> account_map = new HashMap<String, WeixinAccount>();
	private static Map<String,Map<String,String>> dataMap=new HashMap<String,Map<String,String>>();
//	private static Map<String, List<ConnList>> adminConnListInfo = new HashMap<String, List<ConnList>>();
//	private static Map<String, List<ConnDepartment>> tenBigDepartment = new HashMap<String, List<ConnDepartment>>();
	public static void putSysConf(SysConf config) {
		if (null != config) {
			sysconfMap.put(config.getCkey(), config.getCvalue());
		}
	}
	
//	public static void putTenBigDepartment(String accountid ,List<ConnDepartment> tenBigDepartments) {
//		if (null != tenBigDepartment) {
//			tenBigDepartment.put(accountid, tenBigDepartments);
//		}
//	}
//	
//	public static List<ConnDepartment> getTenBigDepartment(String accountid) {
//		return tenBigDepartment.get(accountid);
//	}
//	
//	public static void putAdminConnListInfo(ConnDepartment connDepartment ,List<ConnList> connLists) {
//		adminConnListInfo.put(connDepartment.getdId().toString(), connLists);
//	}
//	
//	public static List<ConnList> getAdminConnListInfo(String d_id) {
//			return adminConnListInfo.get(d_id);
//	}
	public static String getSysConfValue(String ckey) {
		String cvalue = null;
		try {
			cvalue = sysconfMap.get(ckey);
		} catch (Exception e) {
		}
		return cvalue;
	}

	public static Map<String,String> getDatadirMap(String parentkey) {
		Map<String,String> map = null;
		try {
			map = dataMap.get(parentkey);
		} catch (Exception e) {
		}
		return map;
	}

	public static String getDatadirValue(String parentkey,String ckey) {
		String cvalue = null;
		try {
			Map<String,String> map=getDatadirMap(parentkey);
			if(null !=map){
				cvalue = map.get(ckey);
			}
		} catch (Exception e) {
		}
		return cvalue;
	}

	public static void putDatadirList(List<DataDir> list){
		if (null != list && list.size() > 0) {
			List<String> maplist=new ArrayList<String>();
			Map<String,String> map=null;
			for (DataDir info : list) {
				if(Constants.top_datadir_info_parentid.equals(info.getParentkey())){
					map=new HashMap<String,String>();
					dataMap.put(info.getCkey(), map);
					maplist.add(info.getCkey());
				}
			}
			if(maplist.size() >0){
				for(String ckey:maplist){
					for(DataDir info:list){
						if(ckey.equals(info.getParentkey())){
							dataMap.get(ckey).put(info.getCkey(), info.getCvalue());
						}
					}
				}
			}
		}
	}
	public static void putSysConfList(List<SysConf> confList) {
		if (null != confList && confList.size() > 0) {
			for (SysConf info : confList) {
				sysconfMap.put(info.getCkey(), info.getCvalue());
			}
		}
	}

	public static final WeixinAccount getWeChatAccount(String account_id) {
		return account_map.get(account_id);
	}

	public static void putWeixinAccount(List<WeixinAccount> list) {
		if (null != list && list.size() > 0) {
			for (WeixinAccount wx : list) {
				account_map.put(wx.getId(), wx);
			}

		}
	}
}
