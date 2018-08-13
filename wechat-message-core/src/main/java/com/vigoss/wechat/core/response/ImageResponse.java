package com.vigoss.wechat.core.response;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class ImageResponse implements MessageResponse {

	/**
	 * 通过上传多媒体文件，得到的id。
	 */
	private String mediaId;

	public ImageResponse(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String content() {
		return String.format(
				"<Image><MediaId><![CDATA[%s]]></MediaId></Image>", mediaId);
	}

	@Override
	public String msgType() {
		return "image";
	}

	public String getMediaId() {
		return mediaId;
	}
}
