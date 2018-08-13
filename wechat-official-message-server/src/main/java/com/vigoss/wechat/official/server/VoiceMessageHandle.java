package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.OfficialMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.VoiceResponse;
import com.vigoss.wechat.official.message.model.OfficialVoiceMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.voice)
public class VoiceMessageHandle extends OfficialMessageHandle<OfficialVoiceMessage> {
    @Override
    protected MessageResponse doHandle(OfficialVoiceMessage message) {
        return new VoiceResponse(message.getMediaId());
    }
}
