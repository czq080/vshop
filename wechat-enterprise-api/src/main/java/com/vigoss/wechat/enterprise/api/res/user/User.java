package com.vigoss.wechat.enterprise.api.res.user;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:48 2018/3/10
 * @Modified By:
 */
public class User {
    /**
     * userid : zhangsan
     * name : 李四
     * department : [1,2]
     * order : [1,2]
     * position : 后台工程师
     * mobile : 15913215421
     * gender : 1
     * email : zhangsan@gzdev.com
     * isleader : 1
     * avatar : http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0
     * telephone : 020-123456
     * english_name : jackzhang
     * extattr : {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}
     * status : 1
     */

    private String userid;
    private String name;
    private String position;
    private String mobile;
    private String gender;
    private String email;
    private int isleader;
    private String avatar;
    private String telephone;
    private String english_name;
    private ExtattrBean extattr;
    private int status;
    private int enable;
    private List<Integer> department;
    private List<Integer> order;

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

    public int getIsleader() {
        return isleader;
    }

    public void setIsleader(int isleader) {
        this.isleader = isleader;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public ExtattrBean getExtattr() {
        return extattr;
    }

    public void setExtattr(ExtattrBean extattr) {
        this.extattr = extattr;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }

    public List<Integer> getOrder() {
        return order;
    }

    public void setOrder(List<Integer> order) {
        this.order = order;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public static class ExtattrBean {
        private List<AttrsBean> attrs;

        public List<AttrsBean> getAttrs() {
            return attrs;
        }

        public void setAttrs(List<AttrsBean> attrs) {
            this.attrs = attrs;
        }

        public static class AttrsBean {
            /**
             * name : 爱好
             * value : 旅游
             */

            private String name;
            private String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
