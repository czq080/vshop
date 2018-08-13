package com.vigoss.shop.management.api.support;

public enum Code {
    /**
     * 业务正常
     */
    OK(0),
    /**
     * 业务异常
     */
    FAIL(-1),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500);

    private final Integer value;

    private Code(Integer value) {
        this.value = value;
    }

    /**
     * Return the integer value of this status code.
     */
    public Integer value() {
        return this.value;
    }

    public String msg() {
        return Resources.getCodeMessage(this.value);
    }

    public String toString() {
        return this.value.toString();
    }
}
