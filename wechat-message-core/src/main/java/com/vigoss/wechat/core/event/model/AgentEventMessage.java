package com.vigoss.wechat.core.event.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public abstract class AgentEventMessage extends EventMessage {
    public AgentEventMessage(String event) {
        super(event);
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
        return "agentId=" + agentId + ", " + super.toString();
    }
}
