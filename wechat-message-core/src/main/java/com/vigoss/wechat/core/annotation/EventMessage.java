package com.vigoss.wechat.core.annotation;

import com.vigoss.wechat.core.event.type.EventMessageType;

import java.lang.annotation.*;

/**
 * @author chenzhiqiang
 * @date 2018/7/18
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventMessage {
    EventMessageType value();
}
