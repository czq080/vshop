package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentScanCodeEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseScanCodePushEventMessage extends AgentScanCodeEventKeyMessage {
    private static final long serialVersionUID = -6069941803774546617L;

    public EnterpriseScanCodePushEventMessage() {
        super(EventMessageType.scancode_push.name());
    }

    @Override
    public String toString() {
        return "EnterpriseScanCodePushEventMessage{ " + super.toString() + " } ";
    }
}
