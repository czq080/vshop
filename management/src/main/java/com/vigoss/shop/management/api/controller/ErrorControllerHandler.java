package com.vigoss.shop.management.api.controller;

import com.vigoss.shop.common.exception.ShopException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:czq
 * @Description:
 * @Date: 20:15 2018/5/23
 * @Modified By:
 */
@ControllerAdvice
public class ErrorControllerHandler extends BaseController {
    @ExceptionHandler(ShopException.class)
    public ResponseEntity<?> shopExceptionHandler(HttpServletRequest request, ShopException e) {
        e.printStackTrace();
        logger.error("handle exception error >> uri: {} >> msg: {}", request.getRequestURI(), e.getMessage());
        if (e.getCustomMsg() == null)
            return setFailResponse(e.getExceptionMsg());
        return setFailResponse(e.getCustomMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> simpleExceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        logger.error("handle exception error >> uri: {} >> msg: {}", request.getRequestURI(), e.getMessage());
        return setFailResponse(e.getMessage());
    }
}
