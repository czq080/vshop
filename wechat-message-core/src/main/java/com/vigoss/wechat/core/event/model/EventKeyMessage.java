package com.vigoss.wechat.core.event.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class EventKeyMessage extends EventMessage{

    public EventKeyMessage(String event) {
        super(event);
    }

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    @XmlElement(name = "EventKey")
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EventKeyMessage that = (EventKeyMessage) o;
        return Objects.equals(eventKey, that.eventKey);
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (eventKey == null ? 0 : eventKey.hashCode());
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "eventKey=" + eventKey ;
    }
}
