package com.vigoss.wechat.enterprise.api.impl;

import com.alibaba.fastjson.TypeReference;
import com.vigoss.shop.common.exception.common.IOErrorException;
import com.vigoss.wechat.enterprise.api.IMediaApi;
import com.vigoss.wechat.enterprise.api.res.media.MediaDownloadResult;
import com.vigoss.wechat.enterprise.api.res.media.MediaType;
import com.vigoss.wechat.enterprise.api.res.media.MediaUploadResult;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.ContentType;
import com.vigoss.wechat.base.http.HttpHeaders;
import com.vigoss.wechat.base.http.apache.ByteArrayBody;
import com.vigoss.wechat.base.http.apache.FormBodyPart;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.EnterpriseUrlConstant;
import com.vigoss.wechat.base.util.FileUtil;
import com.vigoss.wechat.base.util.IOUtil;
import com.vigoss.wechat.base.util.RegexUtil;
import com.vigoss.wechat.base.util.StringUtil;
import com.vigoss.wechat.base.url.URLManage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:czq
 * @Description: 素材API
 * @Date: 17:28 2018/3/5
 * @Modified By:
 */
public class MediaBaseApi extends EnterpriseBaseApi implements IMediaApi {

    public MediaBaseApi(URLManage urlManage, TokenManager weixinTokenManager) {
        super(urlManage, weixinTokenManager);
    }

    @Override
    public MediaUploadResult uploadMedia(InputStream is, String fileName) {
        byte[] content;
        try {
            content = IOUtil.toByteArray(is);
        } catch (IOException e) {
            throw new IOErrorException(e);
        }
        String suffixName = FileUtil.getFileExtension(fileName);
        if (StringUtil.isBlank(suffixName)) {
            suffixName = FileUtil
                    .getFileType(new ByteArrayInputStream(content));
            fileName = String.format("%s.%s", fileName, suffixName);
        }
        MediaType mediaType = MediaType.file;
        if (",bmp,png,jpeg,jpg,gif,"
                .contains(String.format(",%s,", suffixName))) {
            mediaType = MediaType.image;
        } else if (",mp3,wma,wav,amr,".contains(String.format(",%s,",
                suffixName))) {
            mediaType = MediaType.voice;
        } else if (",rm,rmvb,wmv,avi,mpg,mpeg,mp4,".contains(String.format(
                ",%s,", suffixName))) {
            mediaType = MediaType.video;
        }
        Token token = weixinTokenManager.getCache();
        FormBodyPart formBodyPart = new FormBodyPart("media", new ByteArrayBody(content,
                mediaType.getMimeType().toString(), fileName));
        System.out.println(formBodyPart);
        WeixinResponse response = weixinExecutor.post(String.format(getRequestUri(EnterpriseUrlConstant.media_upload_uri),
                token.getAccessToken(), mediaType.name()),formBodyPart
                );
        return response.getAsObject(new TypeReference<MediaUploadResult>() {
        });
    }

    @Override
    public MediaDownloadResult downloadMedia(String mediaId) {
        Token token = weixinTokenManager.getCache();
        String media_download_uri = getRequestUri(EnterpriseUrlConstant.media_download_uri);
        WeixinResponse response = weixinExecutor.get(String.format(
                media_download_uri, token.getAccessToken(), mediaId));
        HttpHeaders headers = response.getHeaders();
        String contentType = headers.getFirst(HttpHeaders.CONTENT_TYPE);
        String disposition = headers.getFirst(HttpHeaders.CONTENT_DISPOSITION);
        String fileName = RegexUtil
                .regexFileNameFromContentDispositionHeader(disposition);
        if (StringUtil.isBlank(fileName)) {
            fileName = String.format("%s.%s", mediaId,
                    contentType.split("/")[1]);
        }
        return new MediaDownloadResult(response.getContent(),
                ContentType.create(contentType), fileName);
    }
}
