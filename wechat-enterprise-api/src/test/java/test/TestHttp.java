package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vigoss.wechat.base.cache.RedisCacheStorager;
import com.vigoss.wechat.enterprise.WechatEpApiProxy;
import com.vigoss.wechat.enterprise.api.req.message.MessageOfActive;
import com.vigoss.wechat.enterprise.api.req.message.classify.ImageMessage;
import com.vigoss.wechat.enterprise.api.req.message.classify.NewsMessage;
import com.vigoss.wechat.enterprise.api.req.message.classify.TextMessage;
import com.vigoss.wechat.enterprise.api.req.message.member.MemberOfMessage;
import com.vigoss.wechat.enterprise.api.req.message.member.PartyMember;
import com.vigoss.wechat.enterprise.api.req.message.member.TagMember;
import com.vigoss.wechat.enterprise.api.req.message.member.UserMember;
import com.vigoss.wechat.enterprise.api.res.department.DepartmentListApiResult;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:czq
 * @Description:
 * @Date: 15:53 2018/3/1
 * @Modified By:
 */
public class TestHttp {

    @Test
    public void test1() {
//        File file = new File("E://testimge.jpg");
//        System.out.println(file.length());
        WechatEpApiProxy qyApiProxy = new WechatEpApiProxy.Builder("wxef20891dffeb6d1d", "74gR_6aOlttEZheQmn12-nIgDovk3Y9y26LjNJWe0KE", 0, new RedisCacheStorager<>()).build();
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1; i++) {
                DepartmentListApiResult userApiResult = qyApiProxy.getDepartmentList(null);
                System.out.println(Thread.currentThread().getName() + " >> " + JSON.toJSONString(userApiResult));
            }
//            CountDownLatch countDownLatch = new CountDownLatch(100);
//            for (int i = 0; i < 100; i++) {
//                Thread thread = new Thread(() -> {
////                    for (int i = 0; i < 10; i ++){
//                    UserApiResult userApiResult = qyApiProxy.getUser("czqiang5");
//                    System.out.println(Thread.currentThread().getName() + " >> " + JSON.toJSONString(userApiResult));
//                    //}                    }
//                    countDownLatch.countDown();
//                });
//                thread.start();
//            }
//            countDownLatch.await();
            System.out.println(">> job done >>" + (System.currentTimeMillis() - start));
//            qyApiProxy.uploadMedia(new FileInputStream(file),file.getName());
//            MediaDownloadResult mediaDownloadResult = qyApiProxy.downloadMedia("3kqBYzS8N9excE6z9128Tm1SMngOt5cH-jKuvHolkyT1tQGvjIIKEkDBhn2bKj4II");
//            System.out.println(mediaDownloadResult.getContentType().toString());
//            System.out.println(mediaDownloadResult.getFileName());
//            bytesToImageFile(mediaDownloadResult.getContent(), mediaDownloadResult.getFileName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bytesToImageFile(byte[] bytes, String filename) {
        try {
            File file = new File("D:/" + filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes, 0, bytes.length);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        NewsMessage.NewsContent newsContent = new NewsMessage.NewsContent();
        NewsMessage.NewsContent.Article article1 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article2 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article3 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article4 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article5 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article6 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article7 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article8 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article9 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        NewsMessage.NewsContent.Article article10 = new NewsMessage.NewsContent.Article("1", "1", "1", "1", "1");
        newsContent.addArticle(article1, article2, article3, article4, article5, article6, article7, article8, article9, article10);
        NewsMessage newsMessage = new NewsMessage(newsContent);
        System.out.println(JSONObject.toJSONString(newsMessage));
        List<String> xx = new ArrayList<>();
        xx.add("aa");
        xx.add("bb");
        xx.add("cc");
        long start = System.currentTimeMillis();
        MemberOfMessage memberOfMessage = MemberOfMessage.newBuilder().withToUser(new UserMember(xx)).withToParty(new PartyMember(xx)).withToTag(new TagMember(xx)).withToUser(new UserMember(xx)).noMoreMember().build();
        MessageOfActive messageOfActive = new MessageOfActive(1, memberOfMessage, new TextMessage(new TextMessage.TextContent("ddd")));
        messageOfActive.setMemberOfMessage(memberOfMessage);
        System.out.println(System.currentTimeMillis() - start);
        try {
            System.out.println(JSONObject.toJSONString(new ImageMessage(new ImageMessage.ImageContent("123"))));
            String json = JSONObject.toJSONString(messageOfActive);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
