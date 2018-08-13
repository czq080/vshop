package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.EnterpriseMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.enterprise.message.model.EnterpriseTextMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/9
 */
@Message(MessageType.text)
public class EpTextMessageHandle extends EnterpriseMessageHandle<EnterpriseTextMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseTextMessage message) {
        if ("【收到不支持的消息类型，暂无法显示】".equals(message.getContent())) {
            return new TextResponse(message.getContent());
        }
        return new TextResponse("O(∩_∩)O哈哈~");
    }
}
