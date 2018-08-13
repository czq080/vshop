package com.vigoss.wechat.core.handle;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.annotation.Account;

/**
 * @author chenzhiqiang
 * @date 2018/7/18
 */
@Account(WechatAccountType.OFFICIAL)
public abstract class OfficialMessageHandle<T extends BaseMessage> extends AbstractMessageHandleAdapter<T> {
}
