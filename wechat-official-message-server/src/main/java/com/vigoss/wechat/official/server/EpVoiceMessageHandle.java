package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.EnterpriseMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.VoiceResponse;
import com.vigoss.wechat.enterprise.message.model.EnterpriseVoiceMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.voice)
public class EpVoiceMessageHandle extends EnterpriseMessageHandle<EnterpriseVoiceMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseVoiceMessage message) {
        return new VoiceResponse(message.getMediaId());
    }
}
