package com.vigoss.shop.common.exception;

import java.util.Map;

/**
 * @author Jamefeng
 */
public abstract class ShopException extends RuntimeException {

    private transient static final long serialVersionUID = 1L;

    private String respCode;
    private String exceptionMsg;
    private String customMsg;
    private String lang;
    private transient String devMsg;
    private transient String internal;
    private transient Map paramMap = null;

    public ShopException() {
        this(null, null, null);
    }

    public ShopException(Exception e) {
        this(null, e);
    }

    public ShopException(String customMsg) {
        this(null, null, customMsg);
    }

    public ShopException(Exception e, String customMsg) {
        this(null, e, customMsg);
    }

    private ShopException(Map<String, String> paramMap, Exception e) {
        this(paramMap, e, null);
    }

    private ShopException(Map<String, String> paramMap, Exception e, String customMsg) {
        super(printNoSuffixBasicMsg(e), e);
        initExceptionConfig(paramMap);
        handleParentException(e);
        this.customMsg = customMsg;
        this.paramMap = paramMap;
    }

    public static String printNoSuffixBasicMsg(Exception e) {
        if (e == null) {
            return null;
        }
        String result;
        if (e instanceof ShopException) {
            result = ((ShopException) e).getNoSuffixRespCode() + "|" + ((ShopException) e).getDevMsg();
        } else {
            result = e.getMessage();
        }
        return result;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    private void handleParentException(Exception e) {
        if (e == null) {
            return;
        } else {
            String internalMsg;
            if (e instanceof ShopException) {
                internalMsg = ((ShopException) e).printMsg();
            } else {
                internalMsg = "\"" + e.getMessage() + "\"";
            }
            this.setInternal(internalMsg);
        }

    }

    /**
     * 只能是数字,不带字母
     *
     * @param noSuffixRespCode
     * @author Jamefeng
     * @date 2017-04-06
     */
    public ShopException build(String noSuffixRespCode) {
        return build(noSuffixRespCode, null, null);
    }

    protected ShopException build(String respCode, String exceptionMsg, String devMsg) {
        this.respCode = respCode;
        this.exceptionMsg = exceptionMsg;
        this.devMsg = devMsg;
        return this;
    }

    /**
     * 初始化 错误码和错误提示语
     *
     * @param paramMap
     * @author Jamefeng
     * @author Jamefeng
     * @date 2017-04-06
     */
    private void initExceptionConfig(Map paramMap) {
        //从文件中获取配置 (需要优化，暂时每个类进行获取)

        String configKeyName = ExceptionUtil.getNoSuffixConfigKeyName(this.getClass());
        //初始化 respcode、execeptionMsg、devMsg
        this.respCode = ExceptionUtil.getExceptionCode(configKeyName);
        this.devMsg = ExceptionUtil.getExceptionDevMsg(configKeyName);
        this.exceptionMsg = ExceptionUtil.getExceptionTip(configKeyName, paramMap);
    }

    /**
     * 打印和调试信息，json串
     *
     * @author Jamefeng
     * @date 2017-04-08
     */
    protected String printMsg(ShopTypeCode typeCode) {
        String code = this.respCode;
        if (typeCode != null) {
            code = typeCode.getType() + this.respCode;
        }
        return "{\"code\":\"" + code + "\",\"exceptionMsg\":\"" + this.exceptionMsg + "\",\"devMsg\":\"" + this.devMsg + "\",\"internal\":" + this.internal + "}";
    }

    public String printMsg() {
        return printMsg(null);
    }


    public String getRespCode(ShopTypeCode typeCode) {
        return typeCode.getType() + respCode;
    }

    public String getNoSuffixRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }


    /**
     * @return
     */
    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    protected void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg(String suffixStepStr) {

        this.exceptionMsg = ExceptionUtil.getExceptionTip(suffixStepStr, this.getClass(), paramMap);
        return this.exceptionMsg;
    }

    public String getDevMsg() {
        return devMsg;
    }


    public void setDevMsg(String devMsg) {
        this.devMsg = devMsg;
    }


    @Override
    public String getMessage() {
        return this.devMsg;
    }

    @Override
    public String toString() {
        return printMsg();
    }

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }
}
