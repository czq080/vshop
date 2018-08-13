package com.grg.test;

import com.vigoss.wechat.base.exception.WeixinException;
import com.vigoss.wechat.base.http.weixin.WeixinRequestExecutor;
import com.vigoss.wechat.base.http.weixin.WeixinResponse;
import org.junit.Test;

/**
 * @Author:czq
 * @Description:
 * @Date: 15:53 2018/3/1
 * @Modified By:
 */
public class TestHttp {
    @Test
    public void test(){
        try {
            WeixinResponse response = WeixinRequestExecutor.getInstance().get("http://gzzwt.gz.gov.cn/cgi-bin/gettoken?corpid=id&corpsecret=secrect",null);
            System.out.println(response.getAsResult());
        } catch (WeixinException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){

    }
}
