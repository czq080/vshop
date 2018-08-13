package com.vigoss.wechat.core.xml;

import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.type.EncryptType;

import java.io.Serializable;
import java.util.Set;
/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class MessageTransfer implements Serializable {

    private static final long serialVersionUID = 7779948135156353261L;

    /**
     * 加密类型
     */
    private EncryptType encryptType;
    /**
     * 消息接收方
     */
    private String toUserName;
    /**
     * 消息发送方
     */
    private String fromUserName;
    /**
     * 账号
     */
    private WechatAccountType accountType;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * 事件类型
     */
    private String eventType;
    /**
     * 节点集合
     */
    private Set<String> nodeNames;

    public MessageTransfer(EncryptType encryptType, String toUserName, String fromUserName, WechatAccountType accountType, String msgType, String eventType, Set<String> nodeNames) {
        this.encryptType = encryptType;
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.accountType = accountType;
        this.msgType = msgType;
        this.eventType = eventType;
        this.nodeNames = nodeNames;
    }

    public EncryptType getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(EncryptType encryptType) {
        this.encryptType = encryptType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public WechatAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(WechatAccountType accountType) {
        this.accountType = accountType;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Set<String> getNodeNames() {
        return nodeNames;
    }

    public void setNodeNames(Set<String> nodeNames) {
        this.nodeNames = nodeNames;
    }

    @Override
    public String toString() {
        return "MessageTransfer{" +
                ", encryptType=" + encryptType +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", accountType=" + accountType +
                ", msgType='" + msgType + '\'' +
                ", eventType='" + eventType + '\'' +
                ", nodeNames=" + nodeNames +
                '}';
    }
}
