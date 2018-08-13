package com.vigoss.wechat.core.dispatcher;

import com.vigoss.wechat.core.request.MessageRequest;

/**
 * @author chenzhiqiang
 * @date 2018/7/11
 */
public interface DispatcherServlet {
    String handleGet(MessageRequest messageRequest) throws Exception;

    String handlePost(MessageRequest messageRequest, String xml) throws Exception;
}
