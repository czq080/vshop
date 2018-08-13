package com.vigoss.wechat.official.message.model;

import com.vigoss.wechat.core.message.model.GenericLocationMessage;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialLocationMessage extends GenericLocationMessage {
    private static final long serialVersionUID = -2619813377714053243L;

    public OfficialLocationMessage() {
        super(MessageType.location.name());
    }

    @Override
    public String toString() {
        return "OfficialLocationMessage{" + super.toString() + "} ";
    }
}
