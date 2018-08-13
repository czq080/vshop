package com.vigoss.wechat.enterprise.api;

import com.vigoss.wechat.enterprise.api.res.media.MediaDownloadResult;
import com.vigoss.wechat.enterprise.api.res.media.MediaUploadResult;

import java.io.InputStream;

/**
 * @Author:czq
 * @Description:
 * @Date: 17:24 2018/3/5
 * @Modified By:
 */
public interface IMediaApi {
    public MediaUploadResult uploadMedia(InputStream is,
                                         String fileName);

    MediaDownloadResult downloadMedia(String mediaId);
}
