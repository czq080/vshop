package com.vigoss.wechat.core.matcher;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.factory.MessageKey;
import com.vigoss.wechat.core.handle.MessageHandle;
import com.vigoss.wechat.core.interceptor.MessageInterceptor;

import java.util.List;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public interface MessageMatcher {

    /**
     * 匹配消息类型
     *
     * @return 消息类型
     */
    Class<? extends BaseMessage> match(MessageKey messageKey);

    List<MessageInterceptor> matchInterceptors(MessageKey messageKey);

    List<MessageHandle> matchHandles(MessageKey messageKey);
}
