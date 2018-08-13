package com.vigoss.wechat.core.response;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public interface MessageResponse {
    /**
     * 回复的消息类型
     *
     * @return
     */
    String msgType();

    /**
     * 回复的消息内容
     *
     * @return
     */
    String content();
}
