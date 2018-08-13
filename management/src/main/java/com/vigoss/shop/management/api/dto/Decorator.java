package com.vigoss.shop.management.api.dto;

/**
 * @Author:czq
 * @Description:
 * @Date: 23:32 2018/5/27
 * @Modified By:
 */
public abstract class Decorator<T> {
    private T target;

    public Decorator(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
