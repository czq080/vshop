package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.EnterpriseMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.enterprise.message.model.EnterpriseLocationMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.location)
public class EpLocationMessageHandle extends EnterpriseMessageHandle<EnterpriseLocationMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseLocationMessage message) {
        return new TextResponse(String.format("消息类型:%s,事件类型:%s,消息体:%s", MessageType.location, "不是事件", message));
    }
}
