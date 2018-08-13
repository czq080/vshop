package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseMenuViewEventMessage extends AgentEventKeyMessage {

    private static final long serialVersionUID = -5170898439359469918L;

    public EnterpriseMenuViewEventMessage() {
        super(EventMessageType.view.name());
    }

    @Override
    public String toString() {
        return "EnterpriseMenuViewEventMessage{ " + super.toString() + " } ";
    }
}
