package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 22:31 2018/3/4
 * @Modified By:
 */
public abstract class Message {

    private final String msgtype;

    public Message(String messageType) {
        this.msgtype = messageType;
    }

    public String getMsgtype() {
        return msgtype;
    }
}
