package com.huaxi.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-19 17:15:40
 */
@SpringBootApplication
@EntityScan(basePackages= {"com.huaxi.redis.Config"})
@EnableCaching
@EnableScheduling
@Slf4j
public class AppRedis {
    public static void main(String[] args) {

        ApplicationContext ct= SpringApplication.run(AppRedis.class, args);
        log.info("---------------redis发送消息--------------------------");
        StringRedisTemplate template = ct.getBean(StringRedisTemplate.class);
        template.convertAndSend("messagepush", "Hello message !");
        template.convertAndSend("messagepush3", "Hello message3 !");
        /**
         * 发送消息我们使用StringRedisTemplate来发送键和值均为字符串的消息。
         * 在main()方法中我们创建一个Spring应用的Context，初始化消息监听者容器，
         * 开始监听消息。然后获取StringRedisTemplate的实例，往messagepush和messagepush3两个主题发送消息
         */
    }


}
