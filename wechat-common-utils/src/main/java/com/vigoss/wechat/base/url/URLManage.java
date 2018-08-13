package com.vigoss.wechat.base.url;

import java.util.ResourceBundle;

/**
 * @Author:czq
 * @Description:
 * @Date: 18:22 2018/3/3
 * @Modified By:
 */
public abstract class URLManage {

    protected abstract ResourceBundle bundle();

    public abstract String getValue(String key);
}
