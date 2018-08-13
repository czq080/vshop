package com.vigoss.wechat.core.account;

/**
 * @author chenzhiqiang
 * @date 2018/7/17
 */
public class EpWechatAccount extends WechatAccount {

    private static final long serialVersionUID = -6044033540412124374L;

    private Integer agentId;

    public EpWechatAccount(String wechatId, Integer agentId, String token, String encodingAESKey) {
        super(wechatId, token, encodingAESKey);
        this.agentId = agentId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "EpWechatAccount{" +
                "agentId='" + agentId + '\'' +
                "} " + super.toString();
    }
}
