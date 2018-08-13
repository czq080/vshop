package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class MsgIdMessage extends BaseMessage {

    public MsgIdMessage(String msgType) {
        super(msgType);
    }

    /**
     * 消息ID
     */
    @XmlElements({@XmlElement(name = "MsgId"), @XmlElement(name = "MsgID")})
    private long msgId;

    public long getMsgId() {
        return msgId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MsgIdMessage that = (MsgIdMessage) o;
        return msgId == that.msgId;
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + Long.hashCode(msgId);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + " msgId=" + msgId;
    }
}
