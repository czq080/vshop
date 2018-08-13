package com.vigoss.wechat.enterprise.api.req.message.member;


import com.vigoss.wechat.base.util.StringUtil;

import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 9:38 2018/3/5
 * @Modified By:
 */
public abstract class Member {
    public static final char SEPARATOR = '|';

    protected final transient String members;

    public Member(List<String> memberList) {
        this.members = StringUtil.join(memberList, SEPARATOR);
    }
}
