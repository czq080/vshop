/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.vigoss.shop.management.api.controller;

import com.vigoss.shop.management.api.shiro.ShiroUtils;
import com.vigoss.shop.management.api.support.Code;
import com.vigoss.shop.management.api.util.Result;
import com.vigoss.shop.sys.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public abstract class BaseController<T>{


    protected Logger logger;

    public BaseController() {
        logger = LoggerFactory.getLogger(getClass());
    }

    /**
     * 设置成功响应代码
     */
    protected ResponseEntity<Result<T>> setSuccessResponsep() {
        return setResponse(Code.OK, null);
    }

    /**
     * 设置成功响应代码
     */
    protected ResponseEntity<Result<T>> setSuccessResponsep(T data) {
        return setResponse(Code.OK, data);
    }

    /**
     * 设置异常情况响应代码
     */
    protected ResponseEntity<Result<T>> setFailResponse(String msg) {
        return setFailResponse(Code.FAIL, msg);
    }

    /**
     * 设置错误响应代码
     */
    protected ResponseEntity<Result<T>> setErrorResponsep(T data) {
        return setResponse(Code.INTERNAL_SERVER_ERROR, data);
    }

    /**
     * 设置错误响应代码
     */
    protected ResponseEntity<Result<T>> setErrorResponsep() {
        return setResponse(Code.INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 设置响应代码
     */
    protected ResponseEntity<Result<T>> setResponse(Code code) {
        return setResponse(code, null);
    }

    /**
     * 设置响应代码
     */
    private ResponseEntity<Result<T>> setResponse(Code code, T data) {
        Result<T> result = new Result<T>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(code.value());
        result.setMsg(code.msg());
        result.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.ok(result);
    }

    /**
     * 设置响应代码
     */
    private ResponseEntity<Result<T>> setFailResponse(Code code, String msg) {
        Result<T> result = new Result<T>();
        result.setCode(code.value());
        result.setMsg(msg);
        result.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.ok(result);
    }

    protected SysUser getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }

    protected Long getDeptId() {
        return getUser().getDeptId();
    }
}
