package com.vigoss.wechat.enterprise.event.model;

import com.vigoss.wechat.core.event.model.AgentPicEventKeyMessage;
import com.vigoss.wechat.core.event.type.EventMessageType;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EnterprisePicPhotoAlbumEventMessage extends AgentPicEventKeyMessage {

    private static final long serialVersionUID = -5514440140348132106L;

    public EnterprisePicPhotoAlbumEventMessage() {
        super(EventMessageType.pic_photo_or_album.name());
    }

    @Override
    public String toString() {
        return "EnterprisePicPhotoAlbumEventMessage{ " + super.toString() + " } ";
    }
}
