package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.EnterpriseMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.VideoResponse;
import com.vigoss.wechat.enterprise.message.model.EnterpriseVideoMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.video)
public class EpVideoMessageHandle extends EnterpriseMessageHandle<EnterpriseVideoMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseVideoMessage message) {
        return new VideoResponse(message.getMediaId());
    }
}
