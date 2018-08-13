package com.vigoss.wechat.core.annotation;

import com.vigoss.wechat.core.account.WechatAccountType;

import java.lang.annotation.*;

/**
 * @author chenzhiqiang
 * @date 2018/7/18
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Account {
    WechatAccountType value();
}
