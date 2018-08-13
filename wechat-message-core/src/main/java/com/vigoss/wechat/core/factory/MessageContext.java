package com.vigoss.wechat.core.factory;

import com.vigoss.wechat.core.BaseMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public interface MessageContext {
    void register(MessageKey messageKey, Class<? extends BaseMessage> baseMessageClass) throws IllegalAccessException, InstantiationException;

    void cancelRegister(MessageKey messageKey);

    void refresh() throws Exception;
}
