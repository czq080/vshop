package com.vigoss.wechat.enterprise.api;

import com.vigoss.wechat.enterprise.api.req.message.MessageOfActive;
import com.vigoss.wechat.enterprise.api.res.message.MessageApiResult;

/**
 * @Author:czq
 * @Description:
 * @Date: 22:14 2018/3/4
 * @Modified By:
 */
public interface IMessageApi {
    MessageApiResult sendActiveMessage(MessageOfActive messageOfActive);
}
