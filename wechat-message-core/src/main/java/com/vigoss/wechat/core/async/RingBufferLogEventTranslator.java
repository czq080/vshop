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

import com.lmax.disruptor.EventTranslator;
import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.handle.MessageHandleExecutor;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageResponse;

import java.util.concurrent.FutureTask;

/**
 * This class is responsible for writing elements that make up a log event into
 * the ringbuffer {@code RingBufferLogEvent}. After this translator populated
 * the ringbuffer event, the disruptor will update the sequence number so that
 * the event can be consumed by another thread.
 */
public class RingBufferLogEventTranslator implements
        EventTranslator<RingBufferLogEvent> {

    private MessageRequest request;
//    private BaseMessage message;
    private MessageHandleExecutor messageHandleExecutor;
    private CallBack<MessageResponse> callBack;
    private FutureTask<String> task;
    private Class<? extends BaseMessage> targetClass;

    public RingBufferLogEventTranslator(MessageRequest request, FutureTask<String> task,
                                        MessageHandleExecutor messageHandleExecutor, Class<? extends BaseMessage> targetClass,
                                        CallBack<MessageResponse> callBack) {
        this.request = request;
        this.messageHandleExecutor = messageHandleExecutor;
        this.callBack = callBack;
        this.task = task;
        this.targetClass = targetClass;
    }

    // @Override
    @Override
    public void translateTo(final RingBufferLogEvent event, final long sequence) {
        event.setTargetClass(targetClass);
        event.setRequest(request);
        event.setMessageHandleExecutor(messageHandleExecutor);
        event.setCallBack(callBack);
        event.setTask(task);
        clear();
    }

    /**
     * Release references held by this object to allow objects to be
     * garbage-collected.
     */
    private void clear() {
        this.request = null;
        this.targetClass = null;
        this.messageHandleExecutor = null;
        this.callBack = null;
        this.task = null;
    }

    public FutureTask<String> getTask() {
        return task;
    }
}
