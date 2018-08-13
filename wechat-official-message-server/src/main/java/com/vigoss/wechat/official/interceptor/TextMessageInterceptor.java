package com.vigoss.wechat.official.interceptor;

import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.annotation.WechatInterceptor;
import com.vigoss.wechat.core.interceptor.AbstractMessageInterceptor;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.official.message.model.OfficialTextMessage;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
 */
@WechatInterceptor(value = MessageType.text, account = WechatAccountType.OFFICIAL)
public class TextMessageInterceptor extends AbstractMessageInterceptor<OfficialTextMessage> {

    @Override
    public boolean preHandle(MessageRequest request, OfficialTextMessage message) {
        return true;
    }

    @Override
    public void postHandle(MessageRequest request, MessageResponse response, OfficialTextMessage message) {
        System.out.println("before");
    }

    @Override
    public void afterCompletion(MessageRequest request, MessageResponse response, OfficialTextMessage message, Exception exception) {
        System.out.println("after");
    }
}
