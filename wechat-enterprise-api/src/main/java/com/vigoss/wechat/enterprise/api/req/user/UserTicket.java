package com.vigoss.wechat.enterprise.api.req.user;

/**
 * @Author:czq
 * @Description:
 * @Date: 17:58 2018/3/9
 * @Modified By:
 */
public class UserTicket {
    private String user_ticket;

    public UserTicket(String user_ticket) {
        this.user_ticket = user_ticket;
    }

    public String getUser_ticket() {
        return user_ticket;
    }

    public void setUser_ticket(String user_ticket) {
        this.user_ticket = user_ticket;
    }
}
