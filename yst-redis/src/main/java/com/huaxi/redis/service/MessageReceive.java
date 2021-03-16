package com.huaxi.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:  处理MessageReceive 消息接收类的receiveMessage（）处理业务
 * @date 2021-02-19 17:20:27
 */

@Component
@Slf4j
public class MessageReceive {
    @Autowired
    private MessageReceiveHandler messageReceiveHandler;
    /**接收消息的方法*/
    public void receiveMessage(String message){
        log.info("接收消息方法中");
        System.out.println(message);

        messageReceiveHandler.messagePush(message);
    }

}
