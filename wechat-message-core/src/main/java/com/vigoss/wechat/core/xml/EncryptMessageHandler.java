package com.vigoss.wechat.core.xml;

import com.vigoss.wechat.core.MessageConstant;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class EncryptMessageHandler extends DefaultHandler {

    private String toUserName;
    private String encryptContent;
    private String content;

    @Override
    public void startDocument() throws SAXException {
        toUserName = null;
        encryptContent = null;
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if ("encrypt".equalsIgnoreCase(localName)) {
            encryptContent = content;
        } else if ("tousername".equalsIgnoreCase(localName)) {
            toUserName = content;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        this.content = new String(ch, start, length);
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getEncryptContent() {
        return encryptContent;
    }

    public static EncryptMessageHandler parser(String xmlContent)
            throws RuntimeException {
        EncryptMessageHandler global = new EncryptMessageHandler();
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(global);
            xmlReader.parse(new InputSource(new ByteArrayInputStream(xmlContent
                    .getBytes(MessageConstant.UTF_8))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return global;
    }
}
