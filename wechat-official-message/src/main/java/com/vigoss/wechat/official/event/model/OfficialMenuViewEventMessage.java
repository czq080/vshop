package com.vigoss.wechat.official.event.model;

import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.event.model.EventMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class OfficialMenuViewEventMessage extends EventMessage {
    private static final long serialVersionUID = -2928373252957560011L;

    public OfficialMenuViewEventMessage() {
        super(EventMessageType.view.name());
    }

    /**
     * 事件类型
     */
    @XmlElement(name = "MenuID")
    private String menuID;

    public String getMenuID() {
        return menuID;
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (menuID == null ? 0 : menuID.hashCode());
    }

    @Override
    public String toString() {
        return "OfficialMenuViewEventMessage{" +
                "menuID='" + menuID + super.toString() + '\'' +
                "} ";
    }
}
