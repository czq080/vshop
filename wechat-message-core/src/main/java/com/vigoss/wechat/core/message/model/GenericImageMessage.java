package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class GenericImageMessage extends MsgIdMessage {

    /**
     * 图片链接
     */
    @XmlElement(name = "PicUrl")
    private String picUrl;

    /**
     * 图片消息媒体id
     */
    @XmlElement(name = "MediaId")
    private String mediaId;

    public GenericImageMessage(String msgType) {
        super(msgType);
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.odd_prime * super.hashCode() + (picUrl == null ? 0 : picUrl.hashCode());
        result = MessageConstant.odd_prime * result + (mediaId == null ? 0 : mediaId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "picUrl=" + picUrl + ", mediaId=" + mediaId + ", "
                + super.toString();
    }
}
