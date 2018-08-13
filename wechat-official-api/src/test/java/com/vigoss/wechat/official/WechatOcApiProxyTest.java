package com.vigoss.wechat.official;

import com.alibaba.fastjson.JSON;
import com.vigoss.shop.common.exception.ShopException;
import com.vigoss.wechat.base.cache.RedisCacheStorager;
import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.official.api.res.user.UserApiResult;
import org.junit.Test;

/**
 * @author chenzhiqiang
 * @date 2018/7/6
 */
public class WechatOcApiProxyTest {

    private WechatOcApiProxy wechatOcApiProxy = new WechatOcApiProxy.Builder("wx3d0a1af592879d8e", "dbe4b87c412c0641dc9aafa75dc957d9", new RedisCacheStorager<>()).build();

    @Test
    public void getUserInfo() throws InterruptedException {
            Thread[] threads = new Thread[1000];
            for (int i = 0; i < 1000; i++) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                            UserApiResult userApiResult = wechatOcApiProxy.getUserInfo("o8gdns23z2GnNxiXphxF3UXsbEXQ");
                            System.out.println(JSON.toJSONString(userApiResult));
                    }
                });
            }
            for (int i = 0; i < 1000; i++) {
                threads[i].start();
            }
            for (int i = 0; i < 1000; i++) {
                threads[i].join();
            }

    }
}