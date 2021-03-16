package com.yst.config.Thread.read1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program: 多线程
 * @description: 多线程
 * -----------------------------------------------------------------------------
 *  @Description: 配置类实现AsyncConfigurer接口，并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，
 *  * 这样我们就获得一个基于线程池TaskExecutor
 *  * @ClassName: CustomMultiThreadingConfig
 *
 * @date 2021-02-26 09:10:14
 */

@Configuration
@ComponentScan("com.yst.controller")
@EnableAsync//利用@EnableAsync注解开启异步任务支持
@Slf4j
public class CustomMultiThreadingConfig implements AsyncConfigurer {
    //配置核心线程池
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(2);//当前线程数
        threadPool.setMaxPoolSize(120);// 最大线程数
        threadPool.setQueueCapacity(1);//线程池所使用的缓冲队列
        threadPool.setWaitForTasksToCompleteOnShutdown(true);//等待任务在关机时完成--表明等待所有线程执行完
        threadPool.setAwaitTerminationSeconds(60 * 15);// 等待时间 （默认为0，此时立即停止），并没等待xx秒后强制停止
        threadPool.setThreadNamePrefix("MyAsync-");//  线程名称前缀
        threadPool.initialize(); // 初始化
        log.info("-------------------------->>>>开启异常线程池");

        return threadPool;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }


}
