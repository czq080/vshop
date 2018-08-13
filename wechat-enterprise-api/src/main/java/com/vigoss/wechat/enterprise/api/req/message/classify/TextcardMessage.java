package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 14:07 2018/3/5
 * @Modified By:
 */
public class TextcardMessage extends Message {
    private final TextcardContent textcard;

    public TextcardMessage(TextcardContent textcard) {
        super(MessageType.TEXTCARD.getType());
        this.textcard = textcard;
    }

    public TextcardContent getTextcard() {
        return textcard;
    }

    public static class TextcardContent{

        /**
         * title : 领奖通知
         * description : <div class="gray">2016年9月26日</div> <div class="normal">恭喜你抽中iPhone 7一台，领奖码：xxxx</div><div class="highlight">请于2016年10月10日前联系行政同事领取</div>
         * url : URL
         * btntxt : 更多
         */

        private String title;
        private String description;
        private String url;
        private String btntxt;

        public TextcardContent() {
        }

        public TextcardContent(String title, String description, String url, String btntxt) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.btntxt = btntxt;
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBtntxt() {
            return btntxt;
        }

        public void setBtntxt(String btntxt) {
            this.btntxt = btntxt;
        }
    }
}
