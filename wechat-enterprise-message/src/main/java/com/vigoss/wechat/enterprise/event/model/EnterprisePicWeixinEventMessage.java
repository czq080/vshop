package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentPicEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterprisePicWeixinEventMessage extends AgentPicEventKeyMessage {

    private static final long serialVersionUID = -5514440140348132106L;

    public EnterprisePicWeixinEventMessage() {
        super(EventMessageType.pic_weixin.name());
    }

    @Override
    public String toString() {
        return "EnterprisePicWeixinEventMessage{ " + super.toString() + " } ";
    }
}
