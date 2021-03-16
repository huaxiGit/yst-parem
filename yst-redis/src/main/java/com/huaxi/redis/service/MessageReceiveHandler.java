package com.huaxi.redis.service;

import org.springframework.stereotype.Component;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-19 17:22:02
 */

@Component
public class MessageReceiveHandler {
    public void messagePush(String message){

        System.out.println("----------收到消息了message："+message);

    }

}
