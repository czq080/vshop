package com.vigoss.wechat.core.xml;

import com.vigoss.wechat.core.MessageConstant;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.util.MessageUtils;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class MessageTransferHandler extends DefaultHandler {

    private String fromUserName;
    private String toUserName;
    private String msgType;
    private String eventType;
    private Set<String> nodeNames;

    private String content;

    @Override
    public void startDocument() throws SAXException {
        fromUserName = null;
        toUserName = null;
        msgType = null;
        eventType = null;
        nodeNames = new HashSet<>();
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        nodeNames.add(localName);
        localName = localName.toLowerCase();
        if ("fromusername".equals(localName)) {
            fromUserName = content;
        } else if ("tousername".equals(localName)) {
            toUserName = content;
        } else if ("msgtype".equals(localName)) {
            msgType = content.toLowerCase();
        } else if ("event".equals(localName)) {
            eventType = content.toLowerCase();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        this.content = new String(ch, start, length);
    }

    public static MessageTransfer parser(MessageRequest request)
            throws RuntimeException {
        MessageTransferHandler global = new MessageTransferHandler();
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(global);
            xmlReader.parse(new InputSource(new ByteArrayInputStream(request
                    .getOriginalContent().getBytes(MessageConstant.UTF_8))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return new MessageTransfer(request.getEncryptType(), global.toUserName,
                global.fromUserName, request.getType(), global.msgType,
                global.eventType, global.nodeNames);
    }
}
