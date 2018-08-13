package com.vigoss.wechat.core.account;

import java.io.Serializable;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class WechatAccount implements Serializable {

    private static final long serialVersionUID = -626587795951620575L;

    private String wechatId;
    /**
     * 开发者的token
     */
    private String token;
    /**
     * 安全模式下的加密密钥
     */
    private String encodingAESKey;

    public WechatAccount(String wechatId, String token) {
        this(wechatId, token, null);
    }

    public WechatAccount(String wechatId, String token, String encodingAESKey) {
        this.wechatId = wechatId;
        this.token = token;
        this.encodingAESKey = encodingAESKey;
    }


    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    public String getWechatId() {
        return wechatId;
    }

    public String getToken() {
        return token;
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    @Override
    public String toString() {
        return "WechatAccount{" +
                "wechatId='" + wechatId + '\'' +
                ", token='" + token + '\'' +
                ", encodingAESKey='" + encodingAESKey + '\'' +
                '}';
    }
}
