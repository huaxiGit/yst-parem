package com.yst.controller;

import com.yst.service.CustomMultiThreadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program: 多线程
 * @description: 多线程
 * @date 2021-02-26 09:16:40
 */
@Controller
@RequestMapping(value="/multithreading")
public class CustomMultiThreadingController {
    @Autowired
    private CustomMultiThreadingService customMultiThreadingService;

    @ResponseBody
    @GetMapping(value="/dotask")
    public String doTask() {
        for (int i=0;i<10;i++){
            System.out.println("1");
            customMultiThreadingService.executeAysncTask1(i);
            System.out.println("2");
            customMultiThreadingService.executeAsyncTask2(i);
            System.out.println("3");
            customMultiThreadingService.executeAsyncTask3(i);

        }

        return "success";
    }
    //延迟
    @ResponseBody
    @GetMapping(value="/thread")
    public String asyncMethodWithVoidReturnType() {
        System.out.println("线程名称："+Thread.currentThread().getName() + " be ready to read data!");
        try {
            Thread.sleep(1000 * 5);
            System.out.println("---------------------》》》无返回值延迟3秒：");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "已进入到异步";
    }
}
