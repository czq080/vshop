package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.EnterpriseMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.ImageResponse;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.enterprise.message.model.EnterpriseImageMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(value = MessageType.image)
public class EpImageMessageHandle extends EnterpriseMessageHandle<EnterpriseImageMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseImageMessage message) {
        return new ImageResponse(message.getMediaId());
    }
}
