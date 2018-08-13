package com.vigoss.wechat.enterprise.api.res.user;

import com.vigoss.wechat.base.http.weixin.ApiResult;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:47 2018/3/10
 * @Modified By:
 */
public class ListUserApiResult extends ApiResult {

    /**
     * errcode : 0
     * errmsg : ok
     * userlist : [{"userid":"zhangsan","name":"李四","department":[1,2],"order":[1,2],"position":"后台工程师","mobile":"15913215421","gender":"1","email":"zhangsan@gzdev.com","isleader":0,"avatar":"http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0","telephone":"020-123456","english_name":"jackzhang","status":1,"extattr":{"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}}]
     */
    private List<User> userlist;

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }
}
