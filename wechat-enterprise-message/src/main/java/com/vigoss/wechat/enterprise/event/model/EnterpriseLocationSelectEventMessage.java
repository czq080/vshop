package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentLocationEventEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseLocationSelectEventMessage extends AgentLocationEventEventKeyMessage {

    private static final long serialVersionUID = -5514440140348132106L;

    public EnterpriseLocationSelectEventMessage() {
        super(EventMessageType.location_select.name());
    }

    @Override
    public String toString() {
        return "EnterpriseLocationSelectEventMessage{ " + super.toString() + " } ";
    }
}
