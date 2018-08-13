package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.event.model.AgentEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterpriseLocationEventMessage extends AgentEventKeyMessage {
    private static final long serialVersionUID = -7407356547971203101L;

    public EnterpriseLocationEventMessage() {
        super(EventMessageType.location.name());
    }

    @XmlElement(name = "Latitude")
    private double latitude;

    @XmlElement(name = "Longitude")
    private double longitude;

    @XmlElement(name = "Precision")
    private double precision;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getPrecision() {
        return precision;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.odd_prime * super.hashCode() + Double.hashCode(latitude);
        result = MessageConstant.odd_prime * result + Double.hashCode(longitude);
        result = MessageConstant.odd_prime * result + Double.hashCode(precision);
        return result;
    }

    @Override
    public String toString() {
        return "EnterpriseLocationEventMessage{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", precision=" + precision +
                ", " + super.toString() +
                "} ";
    }
}
