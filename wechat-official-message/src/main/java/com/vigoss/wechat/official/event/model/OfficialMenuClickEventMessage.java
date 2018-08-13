package com.vigoss.wechat.official.event.model;

import com.vigoss.wechat.core.event.model.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialMenuClickEventMessage extends EventMessage {
    private static final long serialVersionUID = -3022556785194085067L;

    public OfficialMenuClickEventMessage() {
        super(EventMessageType.click.name());
    }

    @Override
    public String toString() {
        return "OfficialMenuClickEventMessage{" + super.toString() + "} ";
    }
}
