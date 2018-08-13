package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericVoiceMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialVoiceMessage extends GenericVoiceMessage {
    private static final long serialVersionUID = -6877395786820176754L;

    public OfficialVoiceMessage() {
        super(MessageType.voice.name());
    }

    @Override
    public String toString() {
        return "OfficialVoiceMessage{" + super.toString() + "} ";
    }
}
