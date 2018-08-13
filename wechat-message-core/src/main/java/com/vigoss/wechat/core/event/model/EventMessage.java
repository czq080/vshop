package com.vigoss.wechat.core.event.model;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.message.type.MessageType;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class EventMessage extends BaseMessage {

    public EventMessage(String event) {
        super(MessageType.event.name());
        this.event = event;
    }

    /**
     * 事件类型
     *
     */
    @XmlElement(name = "Event")
    private String event;

    public String getEvent() {
        return event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EventMessage that = (EventMessage) o;
        return Objects.equals(event, that.event);
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (event == null ? 0 : event.hashCode());
    }

    @Override
    public String toString() {
        return super.toString() + ", " + "event=" + event ;
    }
}
