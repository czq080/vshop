package com.vigoss.wechat.core.dispatcher;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.factory.AbstractMessageFactory;
import com.vigoss.wechat.core.factory.MessageKey;
import com.vigoss.wechat.core.handle.MessageHandle;
import com.vigoss.wechat.core.handle.MessageHandleExecutor;
import com.vigoss.wechat.core.interceptor.MessageInterceptor;
import com.vigoss.wechat.core.matcher.MessageMatcher;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.response.MessageFormatResponse;
import com.vigoss.wechat.core.response.MessageResponse;
import com.vigoss.wechat.core.type.EncryptType;
import com.vigoss.wechat.core.util.MessageUtils;
import com.vigoss.wechat.core.xml.EncryptMessageHandler;
import com.vigoss.wechat.core.xml.MessageTransfer;
import com.vigoss.wechat.core.xml.MessageTransferHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class MessageDispatcher implements DispatcherServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private Map<WechatAccountType, AbstractMessageFactory> messageFactoryMap;

    private Map<Class<? extends BaseMessage>, Unmarshaller> messageUnmarshaller = new ConcurrentHashMap<>();

    public MessageDispatcher(AbstractMessageFactory... messageFactorys) {
        this.messageFactoryMap = new HashMap<>();
        for (AbstractMessageFactory messageFactory : messageFactorys) {
            messageFactoryMap.put(messageFactory.getWechatAccountType(), messageFactory);
        }
    }

    @Override
    public String handleGet(MessageRequest messageRequest) throws Exception {
        logger.info("received message >> {}", messageRequest.toString());
        if (MessageUtils.isBlank(messageRequest.getAppId()) || messageRequest.getType() == null)
            throw new Exception("appId and type must not be null");

        AbstractMessageFactory factory = messageFactoryMap.get(messageRequest.getType());
        WechatAccount token = factory.getWechatAccount(messageRequest.getAppId(), messageRequest.getAgentId());
        if (token == null)
            throw new Exception("未接入的appId");
        if (!MessageUtils.isBlank(messageRequest.getSignature())
                && MessageUtils.signature(token.getToken(), messageRequest.getTimestamp(), messageRequest.getNonce())
                .equals(messageRequest.getSignature())) {
            logger.info("消息接口校验验证签名成功 >>>>>> " + messageRequest.getAppId());
            return messageRequest.getEchostr();
        }
        // 企业号验证签名
        if (!MessageUtils.isBlank(messageRequest.getMsgSignature()) && MessageUtils
                .signature(token.getToken(), messageRequest.getTimestamp(), messageRequest.getNonce(), messageRequest.getEchostr())
                .equals(messageRequest.getMsgSignature())) {
            logger.info("消息接口校验验证签名成功 >>>>>> " + messageRequest.getAppId());
            return MessageUtils.aesDecrypt(null, token.getEncodingAESKey(), messageRequest.getEchostr());
        }
        throw new Exception("消息接口校验验证签名失败 >>>>>> " + messageRequest.toString());
    }

    @Override
    public String handlePost(MessageRequest messageRequest, String xml) throws Exception {
        logger.info("message request >> {}", messageRequest.toString());
        if (MessageUtils.isBlank(messageRequest.getAppId()) || messageRequest.getType() == null)
            throw new Exception("appId and type must not be null");
        AbstractMessageFactory factory = messageFactoryMap.get(messageRequest.getType());
        WechatAccount token = factory.getWechatAccount(messageRequest.getAppId(), messageRequest.getAgentId());
        if (token == null)
            throw new Exception("未接入的appId");
        if (!MessageUtils.isBlank(messageRequest.getSignature())
                && !MessageUtils.signature(token.getToken(), messageRequest.getTimestamp(), messageRequest.getNonce())
                .equals(messageRequest.getSignature())) {
            throw new Exception("消息接口校验验证签名失败 >>>>>> " + messageRequest.toString());
        }
        // XML消息签名验证
        EncryptMessageHandler encryptMessageHandler;
        if (messageRequest.getEncryptType() == EncryptType.CIPHERTEXT
                && (encryptMessageHandler = EncryptMessageHandler.parser(xml)).getEncryptContent() != null) {
//            if (!MessageUtils.signature(messageRequest.getMessageToken().getToken(), messageRequest.getTimestamp(), messageRequest.getNonce(),
//                    messageRequest.getEncryptContent()).equals(messageRequest.getMsgSignature())) {
//                throw new Exception("消息接口校验验证签名失败 >>>>>> " + messageRequest.toString());
//            }
            messageRequest.setOriginalContent(MessageUtils.aesDecrypt(messageRequest.getAppId(), token.getEncodingAESKey(), encryptMessageHandler.getEncryptContent()));
            messageRequest.setEncryptContent(encryptMessageHandler.getEncryptContent());
            messageRequest.setEncryptType(EncryptType.CIPHERTEXT);
        } else
            messageRequest.setOriginalContent(xml);
        return doDispatcher(messageRequest, factory);
    }

    private String doDispatcher(MessageRequest request, AbstractMessageFactory factory) {
        logger.info("parse message >> {}", request.getOriginalContent());
        MessageTransfer messageTransfer = MessageTransferHandler.parser(request);
        MessageKey messageKey = defineMessageKey(messageTransfer);
        Class<? extends BaseMessage> targetClass = factory.match(messageKey);
        BaseMessage message = messageRead(request.getOriginalContent(), targetClass);
        MessageHandleExecutor messageHandleExecutor = getHandlerExecutor(messageKey, factory);
        logger.info("message key >> {} >> content >> {}", messageKey, message);
        if (messageHandleExecutor.applyPreHandle(request, message)) {
            MessageResponse response = null;
            Exception e = null;
            try {
                response = messageHandleExecutor.getMessageResponse(request, message);
                messageHandleExecutor.applyPostHandle(request, response, message);
                logger.info("post message to wechat >> {}", response.content());
            } catch (Exception var1) {
                var1.printStackTrace();
                e = var1;
            }
            messageHandleExecutor.applyAfterCompletion(request, response, message, e);
            return MessageFormatResponse.getInstance().encode(response, messageTransfer, factory.getWechatAccount(request.getAppId(), request.getAgentId()));
        } else return null;
    }

    private MessageKey defineMessageKey(MessageTransfer messageTransfer) {
        return new MessageKey(
                messageTransfer.getMsgType(), messageTransfer.getEventType(),
                messageTransfer.getAccountType());
    }

    private <T extends BaseMessage> T messageRead(String message, Class<T> clazz) {
        if (clazz == null) {
            return null;
        }
        try {
            Source source = new StreamSource(new ByteArrayInputStream(MessageUtils.getBytesUtf8(message)));
            JAXBElement<T> jaxbElement = getUnmarshaller(clazz).unmarshal(source, clazz);
            return jaxbElement.getValue();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private Unmarshaller getUnmarshaller(Class<? extends BaseMessage> clazz) {
        Unmarshaller unmarshaller = messageUnmarshaller.get(clazz);
        if (unmarshaller == null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
                unmarshaller = jaxbContext.createUnmarshaller();
                messageUnmarshaller.put(clazz, unmarshaller);
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
        return unmarshaller;
    }

    private MessageHandleExecutor getHandlerExecutor(MessageKey messageKey, MessageMatcher messageMatcher) {
        List<MessageHandle> messageHandlers = messageMatcher.matchHandles(messageKey);
        List<MessageInterceptor> messageInterceptors = messageMatcher.matchInterceptors(messageKey);
        return new MessageHandleExecutor(messageHandlers, messageInterceptors);
    }
}
