package com.vigoss.shop.sys.dto;

import com.vigoss.shop.sys.entity.SysMenu;

import java.io.Serializable;

/**
 * @Author:czq
 * @Description:
 * @Date: 14:07 2018/5/25
 * @Modified By:
 */
public abstract class Decorator<T> implements Serializable {
    private T t;

    public Decorator(T t) {
        this.t = t;
    }

    public T getTarget() {
        return t;
    }

    public void setTarget(T t) {
        this.t = t;
    }
}
