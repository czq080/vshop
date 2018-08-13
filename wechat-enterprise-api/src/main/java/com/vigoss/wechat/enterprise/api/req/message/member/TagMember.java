package com.vigoss.wechat.enterprise.api.req.message.member;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 9:40 2018/3/5
 * @Modified By:
 */
public class TagMember extends Member {
    private final String totag;

    public TagMember(List<String> memberList) {
        super(memberList);
        this.totag = members;
    }

    public String getTotag() {
        return totag;
    }
}
