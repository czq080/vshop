package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentEventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseSubscribeEventMessage extends AgentEventMessage {

    private static final long serialVersionUID = -5170898439359469918L;

    public EnterpriseSubscribeEventMessage() {
        super(EventMessageType.subscribe.name());
    }

    @Override
    public String toString() {
        return "EnterpriseSubscribeEventMessage{ " + super.toString() + " } ";
    }
}
