package com.vigoss.wechat.enterprise.api.req.message.member;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 9:40 2018/3/5
 * @Modified By:
 */
public class PartyMember extends Member {
    private String toparty;

    public PartyMember(List<String> memberList) {
        super(memberList);
        this.toparty = members;
    }

    public String getToparty() {
        return toparty;
    }
}
