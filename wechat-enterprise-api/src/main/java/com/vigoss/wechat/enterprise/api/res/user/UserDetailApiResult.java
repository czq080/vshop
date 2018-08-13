package com.vigoss.wechat.enterprise.api.res.user;

import com.vigoss.wechat.base.http.weixin.ApiResult;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:02 2018/3/9
 * @Modified By:
 */
public class UserDetailApiResult extends ApiResult{

    /**
     * userid : lisi
     * name : 李四
     * department : [3]
     * position : 后台工程师
     * mobile : 13050495892
     * gender : 1
     * email : xxx@xx.com
     * avatar : http://shp.qpic.cn/bizmp/xxxxxxxxxxx/0
     */

    private String userid;
    private String name;
    private String position;
    private String mobile;
    private String gender;
    private String email;
    private String avatar;
    private List<Integer> department;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }
}
