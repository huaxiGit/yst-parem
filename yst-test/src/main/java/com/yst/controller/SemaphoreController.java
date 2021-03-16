package com.yst.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Semaphore;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:           //定义 Semaphore并发包,  资源总数 使用剩余线程使用完释放线程
 * @description:
 * @date 2021-03-05 17:41:01
 */
@RestController
@RequestMapping(value="/Semaphore")
@Slf4j
public class SemaphoreController {
    Semaphore semaphore=new Semaphore(2);  //定义资源的总数量
    @GetMapping("/request")
    public String Resquest(){
        int availablePermits=semaphore.availablePermits();//可用资源数
        if(availablePermits>0){
            System.out.println("抢到资源");
        }else{
            System.out.println("资源已被占用，稍后再试");
            return "Resource is busy！";
        }
        try {
            semaphore.acquire(1);  //请求占用一个资源
            System.out.println("资源正在被使用");
            Thread.sleep(3000);//放大资源占用时间，便于观察
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            log.info("释放一个资源:1");
            semaphore.release(1);//释放一个资源
        }
        return "Success";
    }


}
