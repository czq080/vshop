package com.vigoss.wechat.core;

import com.vigoss.wechat.core.message.type.MessageType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public abstract class   BaseMessage implements Serializable {

    /**
     * 开发者微信号/企业号
     */
    @XmlElement(name = "ToUserName")
    private String toUserName;
    /**
     * 发送方账号 即用户的openid/userid
     */
    @XmlElement(name = "FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间 系统毫秒数
     */
    @XmlElement(name = "CreateTime")
    private long createTime;
    /**
     * 消息类型
     */
    @XmlElement(name = "MsgType")
    private String msgType;

    public BaseMessage(String msgType) {
        this.msgType = msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    @XmlTransient
    public MessageType getMsgType() {
        return MessageType.valueOf(msgType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseMessage that = (BaseMessage) o;
        return createTime == that.createTime &&
                Objects.equals(toUserName, that.toUserName) &&
                Objects.equals(fromUserName, that.fromUserName) &&
                Objects.equals(msgType, that.msgType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(toUserName, fromUserName, createTime, msgType);
    }

    @Override
    public String toString() {
        return " toUserName=" + toUserName + ", fromUserName="
                + fromUserName + ", createTime=" + createTime + ", msgType="
                + msgType;
    }
}