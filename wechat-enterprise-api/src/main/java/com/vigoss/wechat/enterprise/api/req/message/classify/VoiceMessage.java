package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 13:52 2018/3/5
 * @Modified By:
 */
public class VoiceMessage extends Message {

    private final VoiceContent voice;

    public VoiceMessage(VoiceContent voice) {
        super(MessageType.VOICE.getType());
        this.voice = voice;
    }

    public VoiceContent getVoice() {
        return voice;
    }

    public static class VoiceContent {
        private String media_id;

        public VoiceContent() {
        }

        public VoiceContent(String media_id) {
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
