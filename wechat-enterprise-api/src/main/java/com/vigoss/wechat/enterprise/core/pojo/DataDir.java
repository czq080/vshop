package com.vigoss.wechat.enterprise.core.pojo;

import java.util.ArrayList;
import java.util.List;

public class DataDir {

	private String ckey;
	private String parentkey;
	private String cvalue;
	private int sort;
	private String typename;
	private List<ConnDepartment> orgChildren=new ArrayList<ConnDepartment>();
	public String getCkey() {
		return ckey;
	}
	public void setCkey(String ckey) {
		this.ckey = ckey;
	}
	public String getParentkey() {
		return parentkey;
	}
	public void setParentkey(String parentkey) {
		this.parentkey = parentkey;
	}
	public String getCvalue() {
		return cvalue;
	}
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public List<ConnDepartment> getOrgChildren() {
		return orgChildren;
	}
	public void addOrgChildren(ConnDepartment orgChildren) {
		this.orgChildren.add(orgChildren);
	}
	@Override
	public String toString() {
		return "DataDir [ckey=" + ckey + ", parentkey=" + parentkey + ", cvalue=" + cvalue + ", sort=" + sort
				+ ", typename=" + typename + ", orgChildren=" + orgChildren + "]";
	}
	
}
