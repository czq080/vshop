package com.vigoss.wechat.base.exception;

import com.vigoss.shop.common.exception.weixin.WeixinBaseException;
import com.vigoss.wechat.base.util.WeixinErrorUtil;

public class WeixinException extends WeixinBaseException {

    private static final long serialVersionUID = 7148145661883468514L;

    private String code;
    private String desc;

    public WeixinException(String code, String desc) {
        this.code = code;
        this.desc = desc;
        build(this.code, WeixinErrorUtil.getText(code), this.desc);
    }

    public WeixinException(String desc) {
        this("-1", desc);
    }

    public String getErrorCode() {
        return code;
    }

    public String getErrorDesc() {
        return desc;
    }

    public String getErrorText() {
        return WeixinErrorUtil.getText(code);
    }

}
