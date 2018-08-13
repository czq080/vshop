package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericTextMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialTextMessage extends GenericTextMessage {
    private static final long serialVersionUID = -3507110667730497430L;

    public OfficialTextMessage() {
        super(MessageType.text.name());
    }

    @Override
    public String toString() {
        return "OfficialTextMessage{" + super.toString() + "} ";
    }
}
