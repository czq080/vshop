package com.vigoss.wechat.core.factory;

import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.message.type.MessageType;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public class MessageKey implements Serializable {
    private static final long serialVersionUID = 4783674939993242347L;

    private final String msgType;

    private final String eventType;

    private final WechatAccountType wechatAccountType;

    public MessageKey(String msgType, String eventType, WechatAccountType wechatAccountType) {
        this.msgType = msgType;
        this.eventType = eventType;
        this.wechatAccountType = wechatAccountType;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getEventType() {
        return eventType;
    }

    public WechatAccountType getWechatAccountType() {
        return wechatAccountType;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.result;
        result = MessageConstant.odd_prime * result + (msgType == null ? 0 : msgType.hashCode());
        result = MessageConstant.odd_prime * result + (eventType == null ? 0 : eventType.hashCode());
        result = MessageConstant.odd_prime * result + (wechatAccountType == null ? 0 : wechatAccountType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageKey that = (MessageKey) o;
        if(!msgType.equals(MessageType.event.name())){
            return Objects.equals(msgType, that.msgType) &&
                    wechatAccountType == that.wechatAccountType;
        }
        return Objects.equals(msgType, that.msgType) &&
                Objects.equals(eventType, that.eventType) &&
                wechatAccountType == that.wechatAccountType;
    }

    @Override
    public String toString() {
        return "MessageKey{" +
                "msgType='" + msgType + '\'' +
                ", eventType='" + eventType + '\'' +
                ", wechatAccountType=" + wechatAccountType +
                '}';
    }
}
