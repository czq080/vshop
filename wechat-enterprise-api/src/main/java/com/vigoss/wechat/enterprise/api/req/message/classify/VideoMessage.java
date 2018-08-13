package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 13:54 2018/3/5
 * @Modified By:
 */
public class VideoMessage extends SafeMessage {

    private final VideoContent video;

    public VideoMessage(VideoContent video) {
        super(MessageType.VIDEO.getType());
        this.video = video;
    }

    public VideoContent getVideo() {
        return video;
    }

    public static class VideoContent {

        /**
         * media_id : MEDIA_ID
         * title : Title
         * description : Description
         */

        private String media_id;
        private String title;
        private String description;

        public VideoContent() {
        }

        public VideoContent(String media_id, String title, String description) {
            this.media_id = media_id;
            this.title = title;
            this.description = description;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
