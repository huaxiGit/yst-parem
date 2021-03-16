package com.yst.service;

import com.yst.config.CustomAsyncScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:   创建线程任务服务
 * @date 2021-02-26 09:13:19
 */
@Slf4j
@Service
public class CustomMultiThreadingService {
    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAysncTask1
     * @Date: 2018年9月21日 下午2:54:32
     * @Author: OnlyMate
     * @Throws
     * @param i
     */
    @Async
    public void executeAysncTask1(Integer i){
        log.info("CustomMultiThreadingService ==> executeAysncTask1 method: 执行异步任务{} ", i);
    }

    /**
     * @Description:通过@Async注解表明该方法是一个异步方法，
     * 如果注解在类级别上，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor
     * @Title: executeAsyncTask2
     * @Date: 2018年9月21日 下午2:55:04
     * @Author: OnlyMate
     * @Throws
     * @param i
     */
    @Async
    public void executeAsyncTask2(Integer i){
        log.info("CustomMultiThreadingService ==> executeAsyncTask2 method: 执行异步任务{} ", i);
    }


    /**
     * @Description: 异步线程调度管理器创建线程任务
     * @Title: executeAsyncTask3
     * @Date: 2018年9月21日 下午3:32:28
     * @Author: OnlyMate
     * @Throws
     * @param i
     */
    public void executeAsyncTask3(Integer i){
        CustomAsyncScheduler.getInstance().getChnlBackendQueryPool().execute(new Runnable() {
            @Override
            public void run() {
                log.info("CustomMultiThreadingService ==> executeAsyncTask3 method: 执行异步任务{} ", i);
            }
        });

    }
    @Async
    public void asyncMethodWithVoidReturnType() {

        System.out.println("线程名称："+Thread.currentThread().getName() + " be ready to read data!");
        try {
            Thread.sleep(1000 * 5);
            System.out.println("---------------------》》》无返回值延迟3秒：");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("进入到异步");
      //  return "已进入到异步";
    }
}
