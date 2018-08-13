package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 22:34 2018/3/4
 * @Modified By:
 */
public enum MessageType {
    TEXT("text"),
    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    FILE("file"),
    TEXTCARD("textcard"),
    NEWS("news"),
    MPNEWS("mpnews")
    ;
    private final String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
