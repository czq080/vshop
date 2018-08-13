package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.OfficialMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.official.message.model.OfficialLinkMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(MessageType.link)
public class LinkMessageHandle extends OfficialMessageHandle<OfficialLinkMessage> {
    @Override
    protected MessageResponse doHandle(OfficialLinkMessage message) {
        return new TextResponse("\\(^o^)/~:" + message.getUrl());
    }
}
