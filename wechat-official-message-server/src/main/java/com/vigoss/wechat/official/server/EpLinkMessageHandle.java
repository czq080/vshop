package com.vigoss.wechat.official.server;

import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.handle.EnterpriseMessageHandle;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;
import com.vigoss.wechat.enterprise.message.model.EnterpriseLinkMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@Message(value = MessageType.link)
public class EpLinkMessageHandle extends EnterpriseMessageHandle<EnterpriseLinkMessage> {
    @Override
    protected MessageResponse doHandle(EnterpriseLinkMessage message) {
        return new TextResponse("\\(^o^)/~:" + message.getUrl());
    }
}
