package com.vigoss.wechat.core.handle;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.message.type.MessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/18
 */
@Message(MessageType.event)
public abstract class OfficialEventMessageHandle<T extends BaseMessage> extends OfficialMessageHandle<T> {
}
