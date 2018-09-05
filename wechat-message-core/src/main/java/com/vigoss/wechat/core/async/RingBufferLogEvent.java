/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package com.vigoss.wechat.core.async;

import com.lmax.disruptor.EventFactory;
import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.handle.MessageHandleExecutor;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.util.JaxbUnMarshallerPool;

import java.util.concurrent.FutureTask;

/**
 * When the Disruptor is started, the RingBuffer is populated with event objects. These objects are then re-used during
 * the life of the RingBuffer.
 */
public class RingBufferLogEvent {

    public static final Factory FACTORY = new Factory();

    private MessageRequest request;
    //    private BaseMessage message;
    private MessageHandleExecutor messageHandleExecutor;
    private CallBack<MessageResponse> callBack;
    private FutureTask<String> task;
    private Class<? extends BaseMessage> targetClass;

    public FutureTask<String> getTask() {
        return task;
    }

    public void setTask(FutureTask<String> task) {
        this.task = task;
    }

    public Class<? extends BaseMessage> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<? extends BaseMessage> targetClass) {
        this.targetClass = targetClass;
    }

    private static class Factory implements EventFactory<RingBufferLogEvent> {

        @Override
        public RingBufferLogEvent newInstance() {
            return new RingBufferLogEvent();
        }
    }

    public RingBufferLogEvent() {
    }

    public RingBufferLogEvent(MessageRequest request, MessageHandleExecutor messageHandleExecutor) {
        this.request = request;
//        this.message = message;
        this.messageHandleExecutor = messageHandleExecutor;
    }

    public MessageRequest getRequest() {
        return request;
    }

    public void setRequest(MessageRequest request) {
        this.request = request;
    }

    public MessageHandleExecutor getMessageHandleExecutor() {
        return messageHandleExecutor;
    }

    public void setMessageHandleExecutor(MessageHandleExecutor messageHandleExecutor) {
        this.messageHandleExecutor = messageHandleExecutor;
    }

    public CallBack<MessageResponse> getCallBack() {
        return callBack;
    }

    public void setCallBack(CallBack<MessageResponse> callBack) {
        this.callBack = callBack;
    }

    public void execute() {
        BaseMessage message = JaxbUnMarshallerPool.getMessage(request.getOriginalContent(), targetClass);
        if (messageHandleExecutor.applyPreHandle(request, message)) {
            Exception e = null;
            MessageResponse response = null;
            try {
                response = messageHandleExecutor.getMessageResponse(request, message);
                messageHandleExecutor.applyPostHandle(request, response, message);
            } catch (Exception var1) {
                var1.printStackTrace();
                e = var1;
            }
            messageHandleExecutor.applyAfterCompletion(request, response, message, e);
            callBack.call(response);
            task.run();
        }
    }

    public void clear() {
        this.request = null;
        this.messageHandleExecutor = null;
        this.callBack = null;
        this.task = null;
        this.targetClass = null;
    }
}
