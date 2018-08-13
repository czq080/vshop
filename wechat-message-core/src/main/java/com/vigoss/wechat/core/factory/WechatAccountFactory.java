package com.vigoss.wechat.core.factory;

import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.account.WechatAccountType;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public interface WechatAccountFactory {

    WechatAccount getWechatAccount(String appId, String agentId);
}
