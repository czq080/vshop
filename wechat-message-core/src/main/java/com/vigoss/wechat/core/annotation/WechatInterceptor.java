package com.vigoss.wechat.core.annotation;

import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.message.type.MessageType;

import java.lang.annotation.*;

/**
 * @author chenzhiqiang
 * @date 2018/7/10
        */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WechatInterceptor {
    MessageType value();

    WechatAccountType account();
}
