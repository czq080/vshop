package com.vigoss.wechat.core.handle;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageResponse;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
abstract class AbstractMessageHandleAdapter<T extends BaseMessage> implements MessageHandle<T> {
    @Override
    public boolean filter(MessageRequest request, T message) {
        return true;
    }

    @Override
    public MessageResponse handle(MessageRequest request, T message) {
        return doHandle(message);
    }

    protected abstract MessageResponse doHandle(T message);

    @Override
    public int sort() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(((MessageHandle)o).sort(), sort());
    }

}
