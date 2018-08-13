package com.vigoss.wechat.enterprise.core.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 通讯录实体类
 * @author fjin
 *
 */
public class ConnList implements Cloneable,Serializable {
	private String userId;//用户Id
	private String userName;//用户姓名
	private String text;//机构名称
	private String mobile;//电话号码
	private String email;//电子邮箱
	private String weixin_id;//微信号
	private String roleId;//角色Id
	private String roleName;//角色
	private Date updateTime;//更新时间
	private String d_Id;//部门Id
	private String d_name;//部门名称
	private String position;//职位
	private int gender;//性别
	private int status;//状态
	private Date createTime;//创建时间
	private String creator;//创建人
	private String remark;//备注
	private String accountId;//企业号ID
	private int inStatus;//在职/离职/
	private int isDel;//启用/禁用
	private String mobileres;
	private String emailres;
	private String idcard;
	private String areaid;
	private String avatar;
	private String t_id;
    private String positioinid;
    private String modify;
    private String empcode;
    private String isonline;
    private String floor;//楼层
    private String distanceX;//距左上角X距离
    private String distanceY;//距左上角Y距离
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getInStatus() {
		return inStatus;
	}
	public void setInStatus(int inStatus) {
		this.inStatus = inStatus;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPostion(String position) {
		this.position = position;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeixin_id() {
		return weixin_id;
	}
	public void setWeixin_id(String weixin_id) {
		this.weixin_id = weixin_id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getD_Id() {
		return d_Id;
	}
	public void setD_Id(String d_Id) {
		this.d_Id = d_Id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public String getMobileres() {
		return mobileres;
	}
	public void setMobileres(String mobileres) {
		this.mobileres = mobileres;
	}
	public String getEmailres() {
		return emailres;
	}
	public void setEmailres(String emailres) {
		this.emailres = emailres;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getT_id() {
        return t_id;
    }
    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
    public String getPositioinid() {
        return positioinid;
    }
    public void setPositioinid(String positioinid) {
        this.positioinid = positioinid;
    }
    public ConnList() {
		super();
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getEmpcode() {
		return empcode;
	}
	public void setEmpcode(String empcode) {
		this.empcode = empcode;
	}
	public String getModify() {
		return modify;
	}
	
	public void setModify(String modify) {
		this.modify = modify;
	}
	public ConnList(String userId, String userName, String mobile, String email, String weixin_id,
			String roleId, String d_Id, String position, int gender, int status, String accountId, int inStatus,
			int isDel, String mobileres, String emailres, String idcard, String areaid) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.weixin_id = weixin_id;
		this.roleId = roleId;
		this.d_Id = d_Id;
		this.position = position;
		this.gender = gender;
		this.status = status;
		this.accountId = accountId;
		this.inStatus = inStatus;
		this.isDel = isDel;
		this.mobileres = mobileres;
		this.emailres = emailres;
		this.idcard = idcard;
		this.areaid = areaid;
	}
	
	public ConnList(String userId, String userName, String mobile, String d_Id, int status, String accountId,
			int inStatus, int isDel) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.d_Id = d_Id;
		this.status = status;
		this.accountId = accountId;
		this.inStatus = inStatus;
		this.isDel = isDel;
	}
	
    public Object clone() {  
    	ConnList o = null;  
        try {  
            o = (ConnList) super.clone();  
        } catch (CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return o;  
    }	
    
	public String getIsonline() {
		return isonline;
	}
	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDistanceX() {
		return distanceX;
	}
	public void setDistanceX(String distanceX) {
		this.distanceX = distanceX;
	}
	public String getDistanceY() {
		return distanceY;
	}
	public void setDistanceY(String distanceY) {
		this.distanceY = distanceY;
	}
	@Override
	public String toString() {
		return "ConnList [userId=" + userId + ", userName=" + userName
				+ ", text=" + text + ", mobile=" + mobile + ", email=" + email
				+ ", weixin_id=" + weixin_id + ", roleId=" + roleId
				+ ", roleName=" + roleName + ", updateTime=" + updateTime
				+ ", d_Id=" + d_Id + ", d_name=" + d_name + ", position="
				+ position + ", gender=" + gender + ", status=" + status
				+ ", createTime=" + createTime + ", creator=" + creator
				+ ", remark=" + remark + ", accountId=" + accountId
				+ ", inStatus=" + inStatus + ", isDel=" + isDel
				+ ", mobileres=" + mobileres + ", emailres=" + emailres
				+ ", idcard=" + idcard + ", areaid=" + areaid + ", avatar="
				+ avatar + ", t_id=" + t_id + ", positioinid=" + positioinid
				+ ", modify=" + modify + ", empcode=" + empcode + ", isonline="
				+ isonline + ", floor=" + floor + ", distanceX=" + distanceX
				+ ", distanceY=" + distanceY + "]";
	} 
	
	
	
	
}
