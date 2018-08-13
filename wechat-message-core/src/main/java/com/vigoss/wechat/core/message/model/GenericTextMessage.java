package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class GenericTextMessage extends MsgIdMessage {

    /**
     * 消息内容
     */
    @XmlElement(name = "Content")
    private String content;

    public GenericTextMessage(String msgType) {
        super(msgType);
    }

    public String getContent() {
        return content;
    }

    @Override
    public int hashCode() {
        return MessageConstant.odd_prime * super.hashCode() + (content == null ? 0 : content.hashCode());
    }

    @Override
    public String toString() {
        return "content='" + content + "," + super.toString();
    }
}
