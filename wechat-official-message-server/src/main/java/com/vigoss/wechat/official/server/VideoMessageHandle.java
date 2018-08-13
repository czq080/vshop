package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.OfficialMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.VideoResponse;
import com.vigoss.wechat.official.message.model.OfficialVideoMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.video)
public class VideoMessageHandle extends OfficialMessageHandle<OfficialVideoMessage> {
    @Override
    protected MessageResponse doHandle(OfficialVideoMessage message) {
        return new VideoResponse(message.getMediaId());
    }
}
