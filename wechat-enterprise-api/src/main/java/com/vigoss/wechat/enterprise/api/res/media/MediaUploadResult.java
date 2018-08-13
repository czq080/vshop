package com.vigoss.wechat.enterprise.api.res.media;

import com.vigoss.wechat.base.http.weixin.ApiResult;

public class MediaUploadResult extends ApiResult {

	private static final long serialVersionUID = -620630472640999536L;

	/**
	 * type : image
	 * media_id : 1G6nrLmr5EC3MMb_-zK1dDdzmd0p7cNliYu9V5w7o8K0
	 * created_at : 1380000000
	 */

	private String type;
	private String media_id;
	private String created_at;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
}
