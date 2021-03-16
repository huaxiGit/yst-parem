package com.yst;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-09 15:42:31
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class webSocketApp {
    public static void main(String[] args) {
        SpringApplication.run(webSocketApp.class,args);
    }
}
