package com.vigoss.wechat.enterprise.api.res.message;


import com.vigoss.wechat.base.http.weixin.ApiResult;

/**
 * @Author:czq
 * @Description:
 * @Date: 11:37 2018/3/5
 * @Modified By:
 */
public class MessageApiResult extends ApiResult {
    /**
     * errcode : 0
     * errmsg : ok
     * invaliduser : userid1|userid2
     * invalidparty : partyid1|partyid2
     * invalidtag : tagid1|tagid2
     */

    private String invaliduser;
    private String invalidparty;
    private String invalidtag;

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }

    public String getInvalidtag() {
        return invalidtag;
    }

    public void setInvalidtag(String invalidtag) {
        this.invalidtag = invalidtag;
    }

    @Override
    public String toString() {
        return "MessageApiResult{" +
                "invaliduser='" + invaliduser + '\'' +
                ", invalidparty='" + invalidparty + '\'' +
                ", invalidtag='" + invalidtag + '\'' +
                "} " + super.toString();
    }
}
