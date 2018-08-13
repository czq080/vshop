package com.vigoss.wechat.enterprise.api.res.media;


import com.vigoss.wechat.base.http.MimeType;

public enum MediaType {
	image(MimeType.IMAGE_JPG), voice(MimeType.AUDIO_MP3), video(MimeType.VIDEO_MPEG4), thumb(MimeType.IMAGE_JPG), file(
			MimeType.MULTIPART_FORM_DATA), news(MimeType.MULTIPART_FORM_DATA);

	MediaType(MimeType mimeType) {
		this.mimeType = mimeType;
	}

	private MimeType mimeType;

	public MimeType getMimeType() {
		return mimeType;
	}
}
