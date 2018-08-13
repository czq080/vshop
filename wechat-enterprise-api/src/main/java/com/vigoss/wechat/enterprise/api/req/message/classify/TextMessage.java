package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 22:33 2018/3/4
 * @Modified By:
 */
public class TextMessage extends SafeMessage {

    private final TextContent text;

    public TextMessage(TextContent text) {
        super(MessageType.TEXT.getType());
        this.text = text;
    }

    public TextContent getText() {
        return text;
    }

    public static class TextContent {
        private String content;

        public TextContent() {
        }

        public TextContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
