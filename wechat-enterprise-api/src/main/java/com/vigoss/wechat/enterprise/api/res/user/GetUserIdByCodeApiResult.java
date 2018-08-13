package com.vigoss.wechat.enterprise.api.res.user;

import com.vigoss.wechat.base.http.weixin.ApiResult;

/**
 * @Author:czq
 * @Description:
 * @Date: 17:59 2018/3/3
 * @Modified By:
 */
public class GetUserIdByCodeApiResult extends ApiResult {
    private String userId;
    private String deviceId;
    private String user_ticket;
    private Long expires_in;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUser_ticket() {
        return user_ticket;
    }

    public void setUser_ticket(String user_ticket) {
        this.user_ticket = user_ticket;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
