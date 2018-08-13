package com.vigoss.wechat.core.interceptor;

import com.vigoss.wechat.core.BaseMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public abstract class AbstractMessageInterceptor<T extends BaseMessage> implements MessageInterceptor<T> {

    @Override
    public int sort() {
        return 0;
    }

    @Override
    public int compareTo(MessageInterceptor o) {
        return Integer.compare(o.sort(), sort());
    }

}
