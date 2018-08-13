package com.vigoss.wechat.core.handle;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.interceptor.MessageInterceptor;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.BlankResponse;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.response.TextResponse;

import java.util.List;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class MessageHandleExecutor<T extends BaseMessage> {

    private List<MessageHandle<T>> messageHandles;

    private List<MessageInterceptor<T>> messageInterceptors;

    public MessageHandleExecutor(List<MessageHandle<T>> messageHandles, List<MessageInterceptor<T>> messageInterceptors) {
        this.messageHandles = messageHandles;
        this.messageInterceptors = messageInterceptors;
    }

    public boolean applyPreHandle(MessageRequest request, T message) {
        if (message != null && messageInterceptors != null) {
            for (MessageInterceptor<T> interceptor : messageInterceptors) {
                if (!interceptor.preHandle(request, message)) {
                    applyAfterCompletion(request, null, message, null);
                    return false;
                }
            }
        }
        return true;
    }

    public void applyPostHandle(MessageRequest request, MessageResponse response,
                                T message) {
        if (messageInterceptors == null || message == null)
            return;
        for (MessageInterceptor<T> interceptor : messageInterceptors) {
            interceptor.postHandle(request, response, message);
        }
    }

    public void applyAfterCompletion(MessageRequest request, MessageResponse response,
                                     T message, Exception exception) {
        if (messageInterceptors == null || message == null)
            return;
        for (MessageInterceptor<T> interceptor : messageInterceptors) {
            try {
                interceptor.afterCompletion(request, response,
                        message, exception);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MessageResponse getMessageResponse(MessageRequest request, T message) {
        MessageResponse response = null;
        if (message == null) {
            return new TextResponse("很抱歉，不支持的消息类型");
        }
        if (messageHandles != null)
            for (MessageHandle<T> messageHandle : messageHandles) {
                if (messageHandle.filter(request, message))
                    response = messageHandle.handle(request, message);
            }
        else
            return new BlankResponse();
        return response;
    }
}
