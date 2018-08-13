package com.vigoss.wechat.enterprise.factory;

import com.vigoss.wechat.core.account.EpWechatAccount;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.event.type.EventMessageType;
import com.vigoss.wechat.core.factory.AbstractMessageFactory;
import com.vigoss.wechat.core.factory.MessageKey;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.enterprise.event.model.*;
import com.vigoss.wechat.enterprise.message.model.*;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class EnterpriseMessageFactory extends AbstractMessageFactory {
    public EnterpriseMessageFactory(String basePackage, EpWechatAccount... epWechatAccounts) throws Exception {
        super(basePackage, WechatAccountType.ENTERPRISE, epWechatAccounts);
    }

    @Override
    protected void initMessage() throws InstantiationException, IllegalAccessException {
        register(new MessageKey(MessageType.link.name(), null, WechatAccountType.ENTERPRISE), EnterpriseLinkMessage.class);
        register(new MessageKey(MessageType.text.name(), null, WechatAccountType.ENTERPRISE), EnterpriseTextMessage.class);
        register(new MessageKey(MessageType.image.name(), null, WechatAccountType.ENTERPRISE), EnterpriseImageMessage.class);
        register(new MessageKey(MessageType.location.name(), null, WechatAccountType.ENTERPRISE), EnterpriseLocationMessage.class);
        register(new MessageKey(MessageType.video.name(), null, WechatAccountType.ENTERPRISE), EnterpriseVideoMessage.class);
        register(new MessageKey(MessageType.voice.name(), null, WechatAccountType.ENTERPRISE), EnterpriseVoiceMessage.class);
        //event
        register(new MessageKey(MessageType.event.name(), EventMessageType.location.name(), WechatAccountType.ENTERPRISE), EnterpriseLocationEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.enter_agent.name(), WechatAccountType.ENTERPRISE), EnterpriseEnterAgentEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.click.name(), WechatAccountType.ENTERPRISE), EnterpriseMenuClickEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.view.name(), WechatAccountType.ENTERPRISE), EnterpriseMenuViewEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.subscribe.name(), WechatAccountType.ENTERPRISE), EnterpriseSubscribeEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.scancode_push.name(), WechatAccountType.ENTERPRISE), EnterpriseScanCodePushEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.scancode_waitmsg.name(), WechatAccountType.ENTERPRISE), EnterpriseScanCodeWaitEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.pic_sysphoto.name(), WechatAccountType.ENTERPRISE), EnterprisePicSysPhotoEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.pic_photo_or_album.name(), WechatAccountType.ENTERPRISE), EnterprisePicPhotoAlbumEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.pic_weixin.name(), WechatAccountType.ENTERPRISE), EnterprisePicWeixinEventMessage.class);
        register(new MessageKey(MessageType.event.name(), EventMessageType.location_select.name(), WechatAccountType.ENTERPRISE), EnterpriseLocationSelectEventMessage.class);
    }
}
