package com.vigoss.wechat.core.response;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class VoiceResponse implements MessageResponse {

	/**
	 * 通过上传多媒体文件，得到的id
	 */
	private String mediaId;

	public VoiceResponse(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String content() {
		return String.format(
				"<Voice><MediaId><![CDATA[%s]]></MediaId></Voice>", mediaId);
	}

	public String getMediaId() {
		return mediaId;
	}

	@Override
	public String msgType() {
		return "voice";
	}
}
