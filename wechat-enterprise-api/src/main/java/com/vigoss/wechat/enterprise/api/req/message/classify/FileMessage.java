package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 14:04 2018/3/5
 * @Modified By:
 */
public class FileMessage extends SafeMessage {
    private final FileContent file;

    public FileMessage(FileContent file) {
        super(MessageType.FILE.getType());
        this.file = file;
    }

    public FileContent getFile() {
        return file;
    }

    public static class FileContent {

        /**
         * media_id : 1Yv-zXfHjSjU-7LH-GwtYqDGS-zz6w22KmWAT5COgP7o
         */

        private String media_id;

        public FileContent(String media_id) {
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
