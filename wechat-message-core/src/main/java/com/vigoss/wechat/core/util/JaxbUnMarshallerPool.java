package com.vigoss.wechat.core.util;

import com.vigoss.wechat.core.BaseMessage;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class JaxbUnMarshallerPool {
    private static KeyedObjectPool<Class<? extends BaseMessage>, Unmarshaller> unmarPool = new GenericKeyedObjectPool(JaxbUnMarshallerFactory.getInstance());

    public static <T extends BaseMessage> T getMessage(String message, Class<T> clazz) {
        if (clazz == null) {
            return null;
        }
        try {
            Source source = new StreamSource(new ByteArrayInputStream(MessageUtils.getBytesUtf8(message)));
            Unmarshaller unmarshaller = unmarPool.borrowObject(clazz);
            JAXBElement<T> jaxbElement = unmarshaller.unmarshal(source, clazz);
            unmarPool.returnObject(clazz, unmarshaller);
            return jaxbElement.getValue();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class JaxbUnMarshallerFactory implements KeyedPooledObjectFactory<Class<? extends BaseMessage>, Unmarshaller> {

    private Map<Class<? extends BaseMessage>, JAXBContext> jaxbContextMap = new HashMap<>();

    private Object lock = new Object();

    private JaxbUnMarshallerFactory() {
    }

    private static class INSTANCE {
        private static final JaxbUnMarshallerFactory HANDLE = new JaxbUnMarshallerFactory();
    }

    public static JaxbUnMarshallerFactory getInstance() {
        return INSTANCE.HANDLE;
    }

    @Override
    public PooledObject<Unmarshaller> makeObject(Class<? extends BaseMessage> aClass) throws Exception {
        JAXBContext jaxbContext = jaxbContextMap.get(aClass);
        if (jaxbContext == null) {
            synchronized (lock) {
                jaxbContext = jaxbContextMap.get(aClass);
                if (jaxbContext == null) {
                    try {
                        jaxbContext = JAXBContext.newInstance(aClass);
                        jaxbContextMap.put(aClass, jaxbContext);
                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return new DefaultPooledObject<>(jaxbContext.createUnmarshaller());
    }

    @Override
    public void destroyObject(Class<? extends BaseMessage> aClass, PooledObject<Unmarshaller> pooledObject) throws Exception {
        System.out.println("desdashudhakdajkdha");
    }

    @Override
    public boolean validateObject(Class<? extends BaseMessage> aClass, PooledObject<Unmarshaller> pooledObject) {
        return true;
    }

    @Override
    public void activateObject(Class<? extends BaseMessage> aClass, PooledObject<Unmarshaller> pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(Class<? extends BaseMessage> aClass, PooledObject<Unmarshaller> pooledObject) throws Exception {

    }
}
