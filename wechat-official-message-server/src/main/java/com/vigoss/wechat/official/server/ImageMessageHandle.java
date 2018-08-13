package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.OfficialMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.ImageResponse;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.official.message.model.OfficialImageMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.image)
public class ImageMessageHandle extends OfficialMessageHandle<OfficialImageMessage> {
    @Override
    protected MessageResponse doHandle(OfficialImageMessage message) {
        return new ImageResponse(message.getMediaId());
    }
}
