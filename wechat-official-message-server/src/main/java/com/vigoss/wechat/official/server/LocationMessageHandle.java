package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.OfficialMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.official.message.model.OfficialLocationMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.location)
public class LocationMessageHandle extends OfficialMessageHandle<OfficialLocationMessage> {
    @Override
    protected MessageResponse doHandle(OfficialLocationMessage message) {
        return new TextResponse("我屮艸芔茻:"+message);
    }
}
