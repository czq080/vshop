package com.vigoss.wechat.enterprise.message.model;

import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.message.model.GenericLocationMessage;
import com.vigoss.wechat.core.message.type.MessageType;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class EnterpriseLocationMessage extends GenericLocationMessage {
    private static final long serialVersionUID = -2619813377714053243L;

    public EnterpriseLocationMessage() {
        super(MessageType.location.name());
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
        return "EnterpriseLocationMessage{ agentId=" + agentId + ", " + super.toString() + "} ";
    }
}
