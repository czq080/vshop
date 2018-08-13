package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class GenericVideoMessage extends MsgIdMessage {

    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "ThumbMediaId")
    private String thumbMediaId;

    public GenericVideoMessage(String msgType) {
        super(msgType);
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.odd_prime * super.hashCode() + (mediaId == null ? 0 : mediaId.hashCode());
        result = MessageConstant.odd_prime * result + (thumbMediaId == null ? 0 : thumbMediaId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId + ", " + super.toString();
    }
}
