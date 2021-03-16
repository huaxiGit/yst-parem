package com.yst;

import com.yst.utilts.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhanghuaxi
 * @title: testApp
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午7:45
 */
@SpringBootApplication
@Slf4j
public class testApp {

    public static void main(String[] args) {
        log.info("==============启动组态=============");
        SpringApplication.run(testApp.class,args);

    }

    // 

}
