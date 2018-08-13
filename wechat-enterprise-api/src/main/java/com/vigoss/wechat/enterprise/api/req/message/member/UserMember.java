package com.vigoss.wechat.enterprise.api.req.message.member;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 9:40 2018/3/5
 * @Modified By:
 */
public class UserMember extends Member {
    private final String touser;

    public UserMember(List<String> memberList) {
        super(memberList);
        this.touser = members;
    }

    public String getTouser() {
        return touser;
    }
}
