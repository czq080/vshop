package com.vigoss.wechat.official.config;

import com.vigoss.wechat.core.account.EpWechatAccount;
import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.dispatcher.MessageDispatcher;
import com.vigoss.wechat.enterprise.factory.EnterpriseMessageFactory;
import com.vigoss.wechat.official.factory.OfficialMessageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenzhiqiang
 * @date 2018/7/9
 */
@Configuration
public class WechatMessageConfiguration {
    @Bean
    public MessageDispatcher messageDispatcher() throws Exception {
        WechatAccount wechatAccount = new WechatAccount("wx3d0a1af592879d8e", "czq");
        WechatAccount wechatAccount1 = new WechatAccount("wx9cb97d8f30766217", "vgshop", "6YzcbBGbDo5KgUmKx9YSvt5ozbJxDWxxXa04pn67Ct9");
        OfficialMessageFactory messageFactory = new OfficialMessageFactory("com.vigoss", wechatAccount, wechatAccount1);
        EpWechatAccount epWechatAccount = new EpWechatAccount("wxef20891dffeb6d1d", 0, "vgshop", "K2A7oTMjOhIKbKEksmaPWlX1fjSVejtBoo3qxvYAhHj");
        EpWechatAccount epWechatAccount1 = new EpWechatAccount("wxef20891dffeb6d1d", 4, "kFq8rkOodeefyMjGMqsch9wYLE00c", "Ktu0BqHlhdQlS9j376qWvqaPZ5oueGN244PvFWOxB0M");
        EpWechatAccount epWechatAccount2 = new EpWechatAccount("wx0f89f499557f6aae", 0, "vgshop", "Ymzlhj7GBrshwcpbgdf6YxdsAcRL31v3oR8PGJPgNiS");
        EpWechatAccount epWechatAccount3 = new EpWechatAccount("wx0f89f499557f6aae", 1000002, "ADCRy6qO", "Ymzlhj7GBrshwcpbgdf6YxdsAcRL31v3oR8PGJPgNiS");
        EnterpriseMessageFactory enterpriseMessageFactory = new EnterpriseMessageFactory("com.vigoss", epWechatAccount, epWechatAccount1, epWechatAccount2, epWechatAccount3);
        return new MessageDispatcher(messageFactory, enterpriseMessageFactory);
    }
}
