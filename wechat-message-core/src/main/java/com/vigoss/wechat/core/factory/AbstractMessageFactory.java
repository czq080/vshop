package com.vigoss.wechat.core.factory;

import com.vigoss.wechat.core.BaseMessage;
import com.vigoss.wechat.core.account.EpWechatAccount;
import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.annotation.Account;
import com.vigoss.wechat.core.annotation.EventMessage;
import com.vigoss.wechat.core.annotation.Message;
import com.vigoss.wechat.core.annotation.WechatInterceptor;
import com.vigoss.wechat.core.event.type.EventMessageType;
import com.vigoss.wechat.core.handle.MessageHandle;
import com.vigoss.wechat.core.interceptor.MessageInterceptor;
import com.vigoss.wechat.core.matcher.MessageMatcher;
import com.vigoss.wechat.core.message.type.MessageType;
import com.vigoss.wechat.core.util.ClassUtil;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenzhiqiang
 * @date 2018/7/7
 */
public abstract class AbstractMessageFactory implements MessageContext, MessageMatcher, WechatAccountFactory {
    private final Map<MessageKey, Class<? extends BaseMessage>> messageRegisterMap = new HashMap<>();
    private final Map<MessageKey, List<MessageInterceptor>> messageInterceptorMap = new HashMap<>();
    private final Map<MessageKey, List<MessageHandle>> messageHandleMap = new HashMap<>();
    private final String basePackage;
    private final WechatAccountType wechatAccountType;
    private final Map<String, WechatAccount> wechatAccountMap = new HashMap<>();

    private static final Map<WechatAccountType, Map<MessageKey, List<Class>>> messageHandleClasses = new HashMap<>();
    private static final Map<WechatAccountType, Map<MessageType, List<Class>>> messageInterceptorClasses = new HashMap<>();

    static {
        messageHandleClasses.put(WechatAccountType.OFFICIAL, new HashMap<>());
        messageHandleClasses.put(WechatAccountType.ENTERPRISE, new HashMap<>());
        messageInterceptorClasses.put(WechatAccountType.OFFICIAL, new HashMap<>());
        messageInterceptorClasses.put(WechatAccountType.ENTERPRISE, new HashMap<>());
    }


    protected AbstractMessageFactory(String basePackage, WechatAccountType wechatAccountType, WechatAccount... wechatAccounts) throws Exception {
        this.basePackage = basePackage;
        this.wechatAccountType = wechatAccountType;
        if (wechatAccounts == null || wechatAccounts.length == 0)
            throw new Exception("wechatAccounts must not be empty");
        if (wechatAccountType == WechatAccountType.ENTERPRISE) {
            for (WechatAccount wechatAccount : wechatAccounts) {
                wechatAccountMap.put(wechatAccount.getWechatId() + ":" + ((EpWechatAccount) wechatAccount).getAgentId(), wechatAccount);
            }
        } else {
            for (WechatAccount wechatAccount : wechatAccounts) {
                wechatAccountMap.put(wechatAccount.getWechatId(), wechatAccount);
            }
        }
        refresh();
    }

    @Override
    public void register(MessageKey messageKey, Class<? extends BaseMessage> baseMessageClass) throws IllegalAccessException, InstantiationException {
        messageRegisterMap.put(messageKey, baseMessageClass);
        List<Class> handleClass = messageHandleClasses.get(wechatAccountType).get(messageKey);
        if (handleClass != null && !handleClass.isEmpty()) {
            List<MessageHandle> handles = new ArrayList<>();
            messageHandleMap.put(messageKey, handles);
            for (Class aClass : handleClass) {
                handles.add((MessageHandle) aClass.newInstance());
            }
        }
        List<Class> interceptorClass = messageInterceptorClasses.get(wechatAccountType).get(MessageType.valueOf(messageKey.getMsgType()));
        if (interceptorClass != null && !interceptorClass.isEmpty()) {
            List<MessageInterceptor> interceptors = new ArrayList<>();
            messageInterceptorMap.put(messageKey, interceptors);
            for (Class aClass : interceptorClass) {
                interceptors.add((MessageInterceptor) aClass.newInstance());
            }
        }
    }

    @Override
    public void cancelRegister(MessageKey messageKey) {
        messageRegisterMap.remove(messageKey);
    }

    @Override
    public Class<? extends BaseMessage> match(MessageKey messageKey) {
        return messageRegisterMap.get(messageKey);
    }

    @Override
    public List<MessageInterceptor> matchInterceptors(MessageKey messageKey) {
        return messageInterceptorMap.get(messageKey);
    }

    @Override
    public List<MessageHandle> matchHandles(MessageKey messageKey) {
        return messageHandleMap.get(messageKey);
    }

    @Override
    public void refresh() throws Exception {
        synchronized (this) {
            initHandles();
            initInterceptors();
            initMessage();
        }
    }

    @Override
    public WechatAccount getWechatAccount(String appId, String agentId) {
        if (wechatAccountType == WechatAccountType.ENTERPRISE)
            return wechatAccountMap.get(appId + ":" + agentId);
        else
            return wechatAccountMap.get(appId);
    }

    protected abstract void initMessage() throws InstantiationException, IllegalAccessException;

    private void initHandles() {
        Set<Class<?>> classes = ClassUtil.getAnnotationClasses(basePackage, Account.class);
        Map<MessageKey, List<Class>> handleListMap = messageHandleClasses.get(wechatAccountType);
        for (Class<?> aClass : classes) {
            if(Modifier.isAbstract(aClass.getModifiers()))
                continue;
            WechatAccountType account = aClass.getAnnotation(Account.class).value();
            if (account != wechatAccountType)
                continue;
            MessageKey messageKey;
            MessageType messageType = aClass.getAnnotation(Message.class).value();
            if (messageType == MessageType.event) {
                EventMessageType eventMessageType = aClass.getAnnotation(EventMessage.class).value();
                messageKey = new MessageKey(messageType.name(), eventMessageType.name(), wechatAccountType);
            } else
                messageKey = new MessageKey(messageType.name(), null, wechatAccountType);
            List<Class> classList = handleListMap.get(messageKey);
            if (classList == null || classList.isEmpty()) {
                classList = new ArrayList<>();
                handleListMap.put(messageKey, classList);
            }
            classList.add(aClass);
        }
    }

    private void initInterceptors() {
        Set<Class<?>> classes = ClassUtil.getAnnotationClasses(basePackage, WechatInterceptor.class);
        Map<MessageType, List<Class>> messageTypeListMap = messageInterceptorClasses.get(wechatAccountType);
        for (Class<?> aClass : classes) {
            WechatAccountType account = aClass.getAnnotation(WechatInterceptor.class).account();
            if (account != wechatAccountType) {
                continue;
            }
            MessageType messageType = aClass.getAnnotation(WechatInterceptor.class).value();
            List<Class> classList = messageTypeListMap.get(messageType);
            if (classList == null || classList.isEmpty()) {
                classList = new ArrayList<>();
                messageTypeListMap.put(messageType, classList);
            }
            classList.add(aClass);
        }
    }

    public WechatAccountType getWechatAccountType() {
        return wechatAccountType;
    }
}
