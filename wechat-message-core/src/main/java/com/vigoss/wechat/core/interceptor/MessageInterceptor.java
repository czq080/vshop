package com.vigoss.wechat.core.interceptor;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageResponse;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public interface MessageInterceptor<T extends BaseMessage> extends Comparable<MessageInterceptor> {

    boolean preHandle(MessageRequest request,
                      T message);

    void postHandle(MessageRequest request,
                    MessageResponse response, T message);

    void afterCompletion(MessageRequest request,
                         MessageResponse response, T message, Exception exception);

    int sort();
}
