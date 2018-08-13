package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class GenericLinkMessage extends MsgIdMessage {

    /**
     * 消息标题
     */
    @XmlElement(name = "Title")
    private String title;
    /**
     * 消息描述
     */
    @XmlElement(name = "Description")
    private String description;
    /**
     * 消息链接
     */
    @XmlElement(name = "Url")
    private String url;

    public GenericLinkMessage(String msgType) {
        super(msgType);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.odd_prime * super.hashCode() + (title == null ? 0 : title.hashCode());
        result = MessageConstant.odd_prime * result + (description == null ? 0 : description.hashCode());
        result = MessageConstant.odd_prime * result + (url == null ? 0 : url.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "title=" + title + ", description=" + description + ", url=" + url + ", " + super.toString();
    }
}
