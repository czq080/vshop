package com.vigoss.wechat.enterprise.message.model;

import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.message.model.GenericVideoMessage;
import com.vigoss.wechat.core.message.type.MessageType;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class EnterpriseVideoMessage extends GenericVideoMessage {
    private static final long serialVersionUID = 1412111584507991724L;

    public EnterpriseVideoMessage() {
        super(MessageType.video.name());
    }

    @XmlElement(name = "AgentID")
    private Integer agentId;

    public Integer getAgentId() {
        return agentId;
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (agentId == null ? 0 : agentId.hashCode());
    }

    @Override
    public String toString() {
        return "EnterpriseVideoMessage{ agentId=" + agentId + ", " + super.toString() + "} ";
    }
}
