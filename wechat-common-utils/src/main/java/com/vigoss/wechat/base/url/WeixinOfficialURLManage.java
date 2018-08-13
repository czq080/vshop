package com.vigoss.wechat.base.url;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:czq
 * @Description: 微信URL管理类
 * @Date: 18:21 2018/3/3
 * @Modified By:
 */
public class WeixinOfficialURLManage extends URLManage {

    private final Pattern uriPattern = Pattern.compile("(\\{[^\\}]*\\})");

    private final static ResourceBundle WEIXIN_BUNDLE;

    static {
        WEIXIN_BUNDLE = ResourceBundle
                .getBundle(WeixinOfficialURLManage.class.getPackage().getName() + ".official");
    }

    @Override
    protected ResourceBundle bundle() {
        return WEIXIN_BUNDLE;
    }

    @Override
    public String getValue(String key) {
        String url = bundle().getString(key);
        Matcher m = uriPattern.matcher(url);
        StringBuffer sb = new StringBuffer();
        String sub;
        while (m.find()) {
            sub = m.group();
            m.appendReplacement(sb,
                    getValue(sub.substring(1, sub.length() - 1)));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}
