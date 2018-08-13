package com.vigoss.wechat.core.message.model;

import com.vigoss.wechat.core.MessageConstant;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class GenericVoiceMessage extends MsgIdMessage {

    /**
     * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    @XmlElement(name = "MediaId")
    private String mediaId;
    /**
     * 语音格式，如amr，speex等
     */
    @XmlElement(name = "Format")
    private String format;
    /**
     * 语音识别结果，UTF8编码
     */
    @XmlElement(name = "Recognition")
    private String recognition;

    public GenericVoiceMessage(String msgType) {
        super(msgType);
    }

    public String getRecognition() {
        return recognition;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public int hashCode() {
        int result = MessageConstant.odd_prime * super.hashCode() + (mediaId == null ? 0 : mediaId.hashCode());
        result = MessageConstant.odd_prime * result + (format == null ? 0 : format.hashCode());
        result = MessageConstant.odd_prime * result + (recognition == null ? 0 : recognition.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "mediaId=" + mediaId + ", format=" + format + ", recognition=" + recognition + ", " + super.toString();
    }
}
