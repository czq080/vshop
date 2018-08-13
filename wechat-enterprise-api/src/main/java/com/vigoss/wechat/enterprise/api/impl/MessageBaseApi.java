package com.vigoss.wechat.enterprise.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import com.vigoss.wechat.base.model.Token;
import com.vigoss.wechat.base.token.TokenManager;
import com.vigoss.wechat.base.url.EnterpriseUrlConstant;
import com.vigoss.wechat.enterprise.api.IMessageApi;
import com.vigoss.wechat.enterprise.api.req.message.MessageOfActive;
import com.vigoss.wechat.enterprise.api.res.message.MessageApiResult;
import com.vigoss.wechat.base.url.URLManage;

/**
 * @Author:czq
 * @Description:企业微信消息API
 * @Date: 22:14 2018/3/4
 * @Modified By:
 */
public class MessageBaseApi extends EnterpriseBaseApi implements IMessageApi {

    public MessageBaseApi(URLManage urlManage, TokenManager weixinTokenManager) {
        super(urlManage, weixinTokenManager);
    }

    @Override
    public MessageApiResult sendActiveMessage(MessageOfActive messageOfActive) {
        try {
            Token token = weixinTokenManager.getCache();
            WeixinResponse response = weixinExecutor.post(String.format(
                    getRequestUri(EnterpriseUrlConstant.message_send_uri), token.getAccessToken()), JSONObject.toJSONString(messageOfActive));
            return response.getAsObject(new TypeReference<MessageApiResult>() {
            });
        } catch (WeixinException weixinException) {
            throw new WeixinException("错误码(微信):" + weixinException.getErrorCode());
        }
    }
}
