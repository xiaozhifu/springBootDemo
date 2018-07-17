package com.fxz.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//全局捕获异常类
//Spring AOP  五种通知：前置通知，后置通知，返回通知，异常通知，环绕通知
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String ,Object> returnError(){
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("errorCode","500");
        errorMap.put("errorMsg","系统错误！");
        return errorMap;
    }

}
