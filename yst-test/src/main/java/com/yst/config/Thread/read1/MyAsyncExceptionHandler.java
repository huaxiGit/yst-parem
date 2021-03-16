package com.yst.config.Thread.read1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program: 多线程异常
 * @description: 多线程异常
 * @date 2021-02-26 10:52:18
 */
@Slf4j
@Configuration
public class MyAsyncExceptionHandler  implements AsyncUncaughtExceptionHandler {
    //自定义异常 手动处理捕获的异常
    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        System.out.println("-------------》》》捕获线程异常信息");
        log.info("Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
        for (Object param : obj) {
            log.info("Parameter value - " + param);
        }
    }
}
