package com.vigoss.wechat.enterprise.api.res.user;

import com.vigoss.wechat.base.http.weixin.ApiResult;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:13 2018/3/9
 * @Modified By:
 */

public class UserApiResult extends ApiResult {
    private User user = new User();

    public String getUserid() {
        return this.user.getUserid();
    }

    public void setUserid(String userid) {
        this.user.setUserid(userid);
    }

    public String getName() {
        return this.user.getName();
    }

    public void setName(String name) {
        this.user.setName(name);
    }

    public String getPosition() {
        return this.user.getPosition();
    }

    public void setPosition(String position) {
        this.user.setPosition(position);
    }

    public String getMobile() {
        return this.user.getMobile();
    }

    public void setMobile(String mobile) {
        this.user.setMobile(mobile);
    }

    public String getGender() {
        return this.user.getGender();
    }

    public void setGender(String gender) {
        this.user.setGender(gender);
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public void setEmail(String email) {
        this.user.setEmail(email);
    }

    public int getIsleader() {
        return this.user.getIsleader();
    }

    public void setIsleader(int isleader) {
        this.user.setIsleader(isleader);
    }

    public String getAvatar() {
        return this.user.getAvatar();
    }

    public void setAvatar(String avatar) {
        this.user.setAvatar(avatar);
    }

    public String getTelephone() {
        return this.user.getTelephone();
    }

    public void setTelephone(String telephone) {
        this.user.setTelephone(telephone);
    }

    public String getEnglish_name() {
        return this.user.getEnglish_name();
    }

    public void setEnglish_name(String english_name) {
        this.user.setEnglish_name(english_name);
    }

    public User.ExtattrBean getExtattr() {
        return this.user.getExtattr();
    }

    public void setExtattr(User.ExtattrBean extattr) {
        this.user.setExtattr(extattr);
    }

    public int getStatus() {
        return this.user.getStatus();
    }

    public void setStatus(int status) {
        this.user.setStatus(status);
    }

    public List<Integer> getDepartment() {
        return this.user.getDepartment();
    }

    public void setDepartment(List<Integer> department) {
        this.user.setDepartment(department);
    }

    public List<Integer> getOrder() {
        return this.user.getOrder();
    }

    public void setOrder(List<Integer> order) {
        this.user.setOrder(order);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEnable() {
        return this.user.getEnable();
    }

    public void setEnable(int enable) {
        this.user.setEnable(enable);
    }
}
