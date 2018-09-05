package com.vigoss.wechat.core.response;

import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.type.EncryptType;
import com.vigoss.wechat.core.util.MessageUtils;
import com.vigoss.wechat.core.xml.MessageTransfer;

/**
 * @author chenzhiqiang
 * @date 2018/7/8
 */
public class MessageFormatResponse {

    private static final String XML_START = "<xml>";
    // ---------------明文节点
    private static final String ELEMENT_TOUSERNAME = "<ToUserName><![CDATA[%s]]></ToUserName>";
    private static final String ELEMENT_FROMUSERNAME = "<FromUserName><![CDATA[%s]]></FromUserName>";
    private static final String ELEMENT_CREATETIME = "<CreateTime><![CDATA[%d]]></CreateTime>";
    private static final String ELEMENT_MSGTYPE = "<MsgType><![CDATA[%s]]></MsgType>";
    // ---------------密文节点
    private static final String ELEMENT_MSGSIGNATURE = "<MsgSignature><![CDATA[%s]]></MsgSignature>";
    private static final String ELEMENT_ENCRYPT = "<Encrypt><![CDATA[%s]]></Encrypt>";
    private static final String ELEMENT_TIMESTAMP = "<TimeStamp><![CDATA[%s]]></TimeStamp>";
    private static final String ELEMENT_NONCE = "<Nonce><![CDATA[%s]]></Nonce>";
    private static final String XML_END = "</xml>";

    private MessageFormatResponse() {
    }

    private static class INSTANCE {
        private static final MessageFormatResponse HANDLE = new MessageFormatResponse();
    }

    public static MessageFormatResponse getInstance() {
        return INSTANCE.HANDLE;
    }

    public String encode(MessageResponse response, MessageTransfer messageTransfer, WechatAccount wechatAccount) {
        if (response == null)
            return null;
        EncryptType encryptType = messageTransfer.getEncryptType();
        StringBuilder content = new StringBuilder();
        content.append(XML_START)
                .append(String.format(ELEMENT_TOUSERNAME, messageTransfer.getFromUserName()))
                .append(String.format(ELEMENT_FROMUSERNAME, messageTransfer.getToUserName()))
                .append(String.format(ELEMENT_CREATETIME, System.currentTimeMillis() / 1000l))
                .append(String.format(ELEMENT_MSGTYPE, response.msgType()))
                .append(response.content())
                .append(XML_END);
        if (encryptType == EncryptType.CIPHERTEXT) {
            String nonce = MessageUtils.generateRandomString(32);
            String timestamp = Long.toString(System.currentTimeMillis() / 1000l);
            String encrtypt = MessageUtils.aesEncrypt(wechatAccount.getWechatId(), wechatAccount.getEncodingAESKey(), content.toString());
            String msgSignature = MessageUtils.signature(wechatAccount.getToken(), nonce, timestamp, encrtypt);
            content.delete(0, content.length());
            content.append(XML_START);
            content.append(String.format(ELEMENT_NONCE, nonce));
            content.append(String.format(ELEMENT_TIMESTAMP, timestamp));
            content.append(String.format(ELEMENT_MSGSIGNATURE, msgSignature));
            content.append(String.format(ELEMENT_ENCRYPT, encrtypt));
            content.append(XML_END);
        }
        return content.toString();
    }
}