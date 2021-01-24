package com.yst.utilts;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghuaxi
 * @title: GlobalExceptionHandler
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午5:31
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..");
    }

    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public Map<String,Object> handleShiroException(Exception ex) {
        Map<String,Object> map=new HashMap<>();
        map.put("message","权限不足,请联系管理员!");
        map.put("status",false);
        map.put("code",414);
        return map;
    }

    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public Map<String,Object> AuthorizationException(Exception e) {
        log.error("没有通过权限验证！", e);
        Map<String,Object> map=new HashMap<>();
        map.put("message","权限认证失败,请联系管理员!");
        map.put("status",false);
        map.put("code",415);
        return map;
    }

    @ResponseBody
    @ExceptionHandler(GuliException.class)
    public Map<String,Object> Exception1(GuliException e) {
        log.error("全局错误！{},{},{}", e.getCode(),e.getMsg(),e.getE());
        Map<String,Object> map=new HashMap<>();
        map.put("message",e.getMsg());
        map.put("status",false);
        map.put("code",e.getCode());
        return map;
    }

}
