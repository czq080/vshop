package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericLinkMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialLinkMessage extends GenericLinkMessage {
    private static final long serialVersionUID = -7475299962084797911L;

    public OfficialLinkMessage() {
        super(MessageType.link.name());
    }

    @Override
    public String toString() {
        return "OfficialLinkMessage{" + super.toString() + "} ";
    }
}
