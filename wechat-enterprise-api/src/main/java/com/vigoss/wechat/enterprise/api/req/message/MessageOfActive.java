package com.vigoss.wechat.enterprise.api.req.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.vigoss.wechat.enterprise.api.req.message.classify.Message;
import com.vigoss.wechat.enterprise.api.req.message.member.MemberOfMessage;

import java.io.Serializable;

/**
 * @Author:czq
 * @Description:
 * @Date: 22:15 2018/3/4
 * @Modified By:
 */
public class MessageOfActive implements Serializable {
    private int agentid;

    @JSONField(unwrapped = true)
    private MemberOfMessage memberOfMessage;

    @JSONField(unwrapped = true)
    private Message message;

    public MessageOfActive(int agentId, MemberOfMessage memberOfMessage, Message message) {
        this.agentid = agentId;
        this.memberOfMessage = memberOfMessage;
        this.message = message;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public MemberOfMessage getMemberOfMessage() {
        return memberOfMessage;
    }

    public void setMemberOfMessage(MemberOfMessage memberOfMessage) {
        this.memberOfMessage = memberOfMessage;
    }
}
