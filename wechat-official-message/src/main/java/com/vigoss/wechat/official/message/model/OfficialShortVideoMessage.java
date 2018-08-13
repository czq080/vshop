package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericVideoMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialShortVideoMessage extends GenericVideoMessage {

    private static final long serialVersionUID = 1924582235532137435L;

    public OfficialShortVideoMessage() {
        super(MessageType.shortvideo.name());
    }

    @Override
    public String toString() {
        return "OfficialShortVideoMessage{" + super.toString() + "} ";
    }
}
