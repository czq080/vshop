package com.vigoss.wechat.enterprise.api.req.message.classify;

/**
 * @Author:czq
 * @Description:
 * @Date: 16:33 2018/3/5
 * @Modified By:
 */
public abstract class SafeMessage extends Message {
    private int safe;

    public SafeMessage(String messageType) {
        super(messageType);
    }

    public int getSafe() {
        return safe;
    }

    public void setSafe(int safe) {
        this.safe = safe;
    }
}
