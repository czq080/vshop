package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentScanCodeEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseScanCodeWaitEventMessage extends AgentScanCodeEventKeyMessage {
    private static final long serialVersionUID = -6069941803774546617L;

    public EnterpriseScanCodeWaitEventMessage() {
        super(EventMessageType.scancode_waitmsg.name());
    }

    @Override
    public String toString() {
        return "EnterpriseScanCodeWaitEventMessage{ " + super.toString() + " } ";
    }
}
