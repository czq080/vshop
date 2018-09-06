package com.vigoss.wechat.core.request;

import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.type.EncryptType;

/**
 * 微信请求
 */
public class MessageRequest {
    /**
     * 请求的URI
     */
    private String uri;
    /**
     * 随机字符串
     */
    private String echostr;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonce;
    /**
     * 参数签名
     */
    private String signature;
    /**
     * AES模式下消息签名
     */
    private String msgSignature;
    /**
     * 加密类型(POST时存在)
     */
    private EncryptType encryptType;

    private WechatAccountType type;

    /**
     * xml消息明文主体
     */
    private String originalContent;

    /**
     * xml消息密文主体(AES时存在)
     */
    private String encryptContent;

    /**
     *
     */
    private String appId;

    /**
     *
     */
    private String agentId;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMsgSignature() {
        return msgSignature;
    }

    public void setMsgSignature(String msgSignature) {
        this.msgSignature = msgSignature;
    }

    public EncryptType getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(EncryptType encryptType) {
        this.encryptType = encryptType;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent;
    }

    public String getEncryptContent() {
        return encryptContent;
    }

    public void setEncryptContent(String encryptContent) {
        this.encryptContent = encryptContent;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public WechatAccountType getType() {
        return type;
    }

    public void setType(WechatAccountType type) {
        this.type = type;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "MessageRequest{" +
                "uri='" + uri + '\'' +
                ", echostr='" + echostr + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", nonce='" + nonce + '\'' +
                ", signature='" + signature + '\'' +
                ", msgSignature='" + msgSignature + '\'' +
                ", encryptType=" + encryptType +
                ", type=" + type +
                ", originalContent='" + originalContent + '\'' +
                ", encryptContent='" + encryptContent + '\'' +
                ", appId='" + appId + '\'' +
                ", agentId='" + agentId + '\'' +
                '}';
    }
}
