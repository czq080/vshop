package com.vigoss.wechat.enterprise;

import com.vigoss.wechat.enterprise.api.IMediaApi;
import com.vigoss.wechat.enterprise.api.ITokenApi;
import com.vigoss.wechat.enterprise.api.IUserApi;
import com.vigoss.wechat.enterprise.api.impl.DepartmentBaseApi;
import com.vigoss.wechat.enterprise.api.impl.MediaBaseApi;
import com.vigoss.wechat.enterprise.api.impl.MessageBaseApi;
import com.vigoss.wechat.enterprise.api.impl.UserBaseApi;
import com.vigoss.wechat.enterprise.api.req.message.MessageOfActive;
import com.vigoss.wechat.enterprise.api.req.user.UserTicket;
import com.vigoss.wechat.enterprise.api.res.department.DepartmentListApiResult;
import com.vigoss.wechat.enterprise.api.res.media.MediaDownloadResult;
import com.vigoss.wechat.enterprise.api.res.media.MediaUploadResult;
import com.vigoss.wechat.enterprise.api.res.message.MessageApiResult;
import com.vigoss.wechat.enterprise.api.res.user.UserApiResult;
import com.vigoss.wechat.enterprise.api.res.user.UserDetailApiResult;
import com.vigoss.wechat.enterprise.token.WeixinEpTicketCreator;
import com.vigoss.wechat.enterprise.token.WeixinEpTokenCreator;
import com.vigoss.wechat.base.cache.CacheStorager;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.EnterpriseUrlConstant;
import com.vigoss.wechat.base.url.WeixinEnterpriseURLManage;
import com.vigoss.wechat.enterprise.api.*;
import com.vigoss.wechat.enterprise.api.res.user.GetUserIdByCodeApiResult;
import com.vigoss.wechat.enterprise.api.res.user.ListUserApiResult;
import com.vigoss.wechat.base.url.URLManage;

import java.io.InputStream;

/**
 * @Author:czq
 * @Description: 企业微信API代理
 * @Date: 17:51 2018/3/3
 * @Modified By:
 */
public class WechatEpApiProxy implements IUserApi, ITokenApi, IMessageApi, IMediaApi, IDepartmentApi {
    private final IUserApi userApi;

    private final IMessageApi messageApi;

    private final IMediaApi mediaApi;

    private final IDepartmentApi departmentApi;

    private final TokenManager accessTokenManager;

    private final TokenManager ticketManager;

    private final CacheStorager<Token> cacheStorager;

    private final URLManage urlManage;

    public WechatEpApiProxy(Builder builder) {
        this.userApi = builder.userApi;
        this.accessTokenManager = builder.accessTokenManager;
        this.cacheStorager = builder.cacheStorager;
        this.ticketManager = builder.ticketManager;
        this.urlManage = builder.urlManage;
        this.messageApi = builder.messageApi;
        this.mediaApi = builder.mediaApi;
        this.departmentApi = builder.departmentApi;
    }

    /*
     *  根据授权code获取企业号成员信息
     */
    @Override
    public GetUserIdByCodeApiResult getUserIdByCode(String code) {
        return userApi.getUserIdByCode(code);
    }

    @Override
    public UserDetailApiResult getUserDetail(UserTicket userTicket) {
        return userApi.getUserDetail(userTicket);
    }

    @Override
    public UserApiResult getUser(String userid) {
        return userApi.getUser(userid);
    }

    @Override
    public ListUserApiResult listUserDetail(int partyId, boolean fetchChild, boolean isdetail) {
        return userApi.listUserDetail(partyId, fetchChild, isdetail);
    }

    /*
     *  获取accesstoken
     */
    @Override
    public String getAccessToken() {
        return accessTokenManager.getAccessToken();
    }

    /*
     *  获取jssdk ticket
     */
    @Override
    public String getJSSDKTicket() {
        return ticketManager.getAccessToken();
    }

    /*
     *  获取微信api url管理器
     */
    public URLManage getUrlManage() {
        return urlManage;
    }

    /*
     *  发送企业号消息-主动消息模块
     */
    @Override
    public MessageApiResult sendActiveMessage(MessageOfActive messageOfActive) {
        return messageApi.sendActiveMessage(messageOfActive);
    }

    /*
     *  上传临时素材
     */
    @Override
    public MediaUploadResult uploadMedia(InputStream is, String fileName) {
        return mediaApi.uploadMedia(is, fileName);
    }

    /*
     *  下载临时素材
     */
    @Override
    public MediaDownloadResult downloadMedia(String mediaId) {
        return mediaApi.downloadMedia(mediaId);
    }

    @Override
    public DepartmentListApiResult getDepartmentList(Integer departmentId) {
        return departmentApi.getDepartmentList(departmentId);
    }

    public static class Builder {
        private final String corpId;

        private final String corpSecret;

        private final Integer agentId;

        private final IUserApi userApi;

        private final IMessageApi messageApi;

        private final IMediaApi mediaApi;

        private final IDepartmentApi departmentApi;

        private final TokenManager accessTokenManager;

        private final TokenManager ticketManager;
        /**
         * token存储
         */
        private final CacheStorager<Token> cacheStorager;

        private final URLManage urlManage;

        public Builder(String corpId, String corpSecret, Integer agentId, CacheStorager<Token> cacheStorager) {
            this.corpId = corpId;
            this.corpSecret = corpSecret;
            this.agentId = agentId;
            this.urlManage = new WeixinEnterpriseURLManage();
            this.accessTokenManager = new TokenManager(new WeixinEpTokenCreator(corpId, agentId, corpSecret, urlManage.getValue(EnterpriseUrlConstant.assess_token_url)), cacheStorager);
            this.ticketManager = new TokenManager(new WeixinEpTicketCreator(corpId, agentId, urlManage.getValue(EnterpriseUrlConstant.js_ticket_url), accessTokenManager), cacheStorager);
            this.userApi = new UserBaseApi(this.urlManage, this.accessTokenManager);
            this.mediaApi = new MediaBaseApi(this.urlManage, this.accessTokenManager);
            this.messageApi = new MessageBaseApi(this.urlManage, this.accessTokenManager);
            this.departmentApi = new DepartmentBaseApi(this.urlManage, this.accessTokenManager);
            this.cacheStorager = cacheStorager;
        }

        public WechatEpApiProxy build() {
            return new WechatEpApiProxy(this);
        }
    }
}
