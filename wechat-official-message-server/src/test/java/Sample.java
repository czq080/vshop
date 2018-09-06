import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.vigoss.wechat.core.account.EpWechatAccount;
import com.vigoss.wechat.core.account.WechatAccount;
import com.vigoss.wechat.core.account.WechatAccountType;
import com.vigoss.wechat.core.dispatcher.MessageDispatcher;
import com.vigoss.wechat.core.request.MessageRequest;
import com.vigoss.wechat.core.type.EncryptType;
import com.vigoss.wechat.enterprise.factory.EnterpriseMessageFactory;
import com.vigoss.wechat.official.factory.OfficialMessageFactory;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Sample {

    @Test
    public void test() throws Exception {
        WechatAccount wechatAccount = new WechatAccount("wx3d0a1af592879d8e", "czq");
        WechatAccount wechatAccount1 = new WechatAccount("wx9cb97d8f30766217", "vgshop", "6YzcbBGbDo5KgUmKx9YSvt5ozbJxDWxxXa04pn67Ct9");
        OfficialMessageFactory messageFactory = new OfficialMessageFactory("com.vigoss", wechatAccount, wechatAccount1);
        EpWechatAccount epWechatAccount = new EpWechatAccount("wxef20891dffeb6d1d", 0, "vgshop", "K2A7oTMjOhIKbKEksmaPWlX1fjSVejtBoo3qxvYAhHj");
        EpWechatAccount epWechatAccount1 = new EpWechatAccount("wxef20891dffeb6d1d", 4, "kFq8rkOodeefyMjGMqsch9wYLE00c", "Ktu0BqHlhdQlS9j376qWvqaPZ5oueGN244PvFWOxB0M");
        EpWechatAccount epWechatAccount2 = new EpWechatAccount("wx0f89f499557f6aae", 0, "vgshop", "Ymzlhj7GBrshwcpbgdf6YxdsAcRL31v3oR8PGJPgNiS");
        EpWechatAccount epWechatAccount3 = new EpWechatAccount("wx0f89f499557f6aae", 1000002, "ADCRy6qO", "Ymzlhj7GBrshwcpbgdf6YxdsAcRL31v3oR8PGJPgNiS");
        EnterpriseMessageFactory enterpriseMessageFactory = new EnterpriseMessageFactory("com.vigoss", epWechatAccount, epWechatAccount1, epWechatAccount2, epWechatAccount3);
        MessageDispatcher dispatcher = new MessageDispatcher(messageFactory, enterpriseMessageFactory);
        String sToken = "kFq8rkOodeefyMjGMqsch9wYLE00c";
        String sCorpID = "wxef20891dffeb6d1d";
        String sEncodingAESKey = "Ktu0BqHlhdQlS9j376qWvqaPZ5oueGN244PvFWOxB0M";

        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread[] threads = new Thread[1];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 1000000) {
                        String trim = String.valueOf(System.currentTimeMillis() / 1000);
                        String uid = UUID.randomUUID().toString().replaceAll("-", "");
                        String sRespData = "<xml><ToUserName><![CDATA[wxef20891dffeb6d1d]]></ToUserName><FromUserName><![CDATA[czqiang]]></FromUserName><CreateTime>" + trim + "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>" + System.currentTimeMillis() / 1000 + "</MsgId><AgentID>4</AgentID></xml>";
                        try {
                            String sEncryptMsg = wxcpt.EncryptMsg(sRespData, trim, uid);
                            MessageRequest request = new MessageRequest();
                            request.setAppId("wxef20891dffeb6d1d");
                            request.setType(WechatAccountType.ENTERPRISE);
                            request.setEncryptType(EncryptType.CIPHERTEXT);
                            request.setAgentId("4");
                            dispatcher.handlePost(request, sEncryptMsg);
                        } catch (Exception e) {
                            e.printStackTrace();
                            // 加密失败
                        }
                        i++;
                    }
                    countDownLatch.countDown();
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        countDownLatch.await();
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }
}
