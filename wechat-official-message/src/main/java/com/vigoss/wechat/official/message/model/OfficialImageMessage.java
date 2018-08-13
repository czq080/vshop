package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericImageMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialImageMessage extends GenericImageMessage {
    private static final long serialVersionUID = -6281876735710815667L;

    public OfficialImageMessage() {
        super(MessageType.image.name());
    }

    @Override
    public String toString() {
        return "OfficialImageMessage{" + super.toString() + "} ";
    }
}
