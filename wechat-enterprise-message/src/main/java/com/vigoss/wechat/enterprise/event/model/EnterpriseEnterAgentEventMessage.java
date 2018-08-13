package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseEnterAgentEventMessage extends AgentEventKeyMessage {
    private static final long serialVersionUID = -6069941803774546617L;

    public EnterpriseEnterAgentEventMessage() {
        super(EventMessageType.enter_agent.name());
    }

    @Override
    public String toString() {
        return "EnterpriseEnterAgentEventMessage{ " + super.toString() + " } ";
    }
}
