package com.yst.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-24 19:06:10
 */

@Component
@Slf4j
public class DirectConsumer {
   /* @RabbitListener(queues = {"directQueue", "logDirectQueue"})
    public void processMessage(String msg) {
        log.info("321489423373982374832478474084");
        System.err.println("consumer receive a message:" + msg);
    }*/

}
