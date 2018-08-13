package com.vigoss.wechat.core.handle;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageResponse;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public interface MessageHandle<T extends BaseMessage> extends Comparable {

    boolean filter(MessageRequest request, T message);

    MessageResponse handle(MessageRequest request, T message);

    int sort();
}
