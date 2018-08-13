package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 13:44 2018/3/5
 * @Modified By:
 */
public class ImageMessage extends SafeMessage {
    private final ImageContent image;

    public ImageMessage(ImageContent image) {
        super(MessageType.IMAGE.getType());
        this.image = image;
    }

    public ImageContent getImage() {
        return image;
    }

    public static class ImageContent {
        private String media_id;

        public ImageContent() {
        }

        public ImageContent(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
