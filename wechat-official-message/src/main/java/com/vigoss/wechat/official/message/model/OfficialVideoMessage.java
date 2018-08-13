package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericVideoMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialVideoMessage extends GenericVideoMessage {
    private static final long serialVersionUID = 1412111584507991724L;

    public OfficialVideoMessage() {
        super(MessageType.video.name());
    }

    @Override
    public String toString() {
        return "OfficialVideoMessage{" + super.toString() + "} ";
    }
}
