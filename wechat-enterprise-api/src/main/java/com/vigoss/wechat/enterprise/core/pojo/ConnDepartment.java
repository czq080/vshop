package com.vigoss.wechat.enterprise.core.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConnDepartment implements Serializable {
    private Long tTd;

    private Long dId;

    private String dName;

    private String dParentid;

    private Integer dOrder;

    private Date createtime;

    private String creator;

    private String remark;

    private Date updatetime;

    private String accountid;

    private String accountname;

    private String area;

    private Short isDepart;

    private BigDecimal lvl;

    private String childrennum;

    private String longitude;

    private String latitude;

    private String address;

    private Short statu;

    private String phone;

    private String weekStart;

    private String weekEnd;

    private String satStart;

    private String satEnd;

    private String sunStart;

    private String sunEnd;

    private String code;

    private String areaname;

    private String delay_serv;
    
    private String loan_busi;
    
    private String large_chsh;
    
    private String inter_busi;
    
    private String crs;
    
    
    private String dids;

    private static final long serialVersionUID = 1L;

    public Long gettTd() {
        return tTd;
    }

    public void settTd(Long tTd) {
        this.tTd = tTd;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdParentid() {
        return dParentid;
    }

    public void setdParentid(String dParentid) {
        this.dParentid = dParentid == null ? null : dParentid.trim();
    }

    public Integer getdOrder() {
        return dOrder;
    }

    public void setdOrder(Integer dOrder) {
        this.dOrder = dOrder;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Short getIsDepart() {
        return isDepart;
    }

    public void setIsDepart(Short isDepart) {
        this.isDepart = isDepart;
    }

    public BigDecimal getLvl() {
        return lvl;
    }

    public void setLvl(BigDecimal lvl) {
        this.lvl = lvl;
    }

    public String getChildrennum() {
        return childrennum;
    }

    public void setChildrennum(String childrennum) {
        this.childrennum = childrennum == null ? null : childrennum.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getStatu() {
        return statu;
    }

    public void setStatu(Short statu) {
        this.statu = statu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWeekStart() {
        return weekStart;
    }

    public void setWeekStart(String weekStart) {
        this.weekStart = weekStart == null ? null : weekStart.trim();
    }

    public String getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(String weekEnd) {
        this.weekEnd = weekEnd == null ? null : weekEnd.trim();
    }

    public String getSatStart() {
        return satStart;
    }

    public void setSatStart(String satStart) {
        this.satStart = satStart == null ? null : satStart.trim();
    }

    public String getSatEnd() {
        return satEnd;
    }

    public void setSatEnd(String satEnd) {
        this.satEnd = satEnd == null ? null : satEnd.trim();
    }

    public String getSunStart() {
        return sunStart;
    }

    public void setSunStart(String sunStart) {
        this.sunStart = sunStart == null ? null : sunStart.trim();
    }

    public String getSunEnd() {
        return sunEnd;
    }

    public void setSunEnd(String sunEnd) {
        this.sunEnd = sunEnd == null ? null : sunEnd.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }
    
    
	public String getDelay_serv() {
        return delay_serv;
    }

    public void setDelay_serv(String delay_serv) {
        this.delay_serv = delay_serv;
    }

    public String getLoan_busi() {
        return loan_busi;
    }

    public void setLoan_busi(String loan_busi) {
        this.loan_busi = loan_busi;
    }

    public String getLarge_chsh() {
        return large_chsh;
    }

    public void setLarge_chsh(String large_chsh) {
        this.large_chsh = large_chsh;
    }

    public String getInter_busi() {
        return inter_busi;
    }

    public void setInter_busi(String inter_busi) {
        this.inter_busi = inter_busi;
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @Override
	public String toString() {
		return "ConnDepartment [tTd=" + tTd + ", dId=" + dId + ", dName=" + dName + ", dParentid=" + dParentid
				+ ", dOrder=" + dOrder + ", createtime=" + createtime + ", creator=" + creator + ", remark=" + remark
				+ ", updatetime=" + updatetime + ", accountid=" + accountid + ", accountname=" + accountname + ", area="
				+ area + ", isDepart=" + isDepart + ", lvl=" + lvl + ", childrennum=" + childrennum + ", longitude="
				+ longitude + ", latitude=" + latitude + ", address=" + address + ", statu=" + statu + ", phone="
				+ phone + ", weekStart=" + weekStart + ", weekEnd=" + weekEnd + ", satStart=" + satStart + ", satEnd="
				+ satEnd + ", sunStart=" + sunStart + ", sunEnd=" + sunEnd + ", code=" + code + ", areaname=" + areaname
				+ "]";
	}

    public String getDids() {
        return dids;
    }

    public void setDids(String dids) {
        this.dids = dids;
    }
    
}