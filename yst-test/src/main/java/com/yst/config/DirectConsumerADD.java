package com.yst.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-24 19:08:33
 */

@Configuration
public class DirectConsumerADD {
    @Bean
    public Queue logDirectQueue() {
        return new Queue("logDirectQueue");
    }

    @Bean
    public DirectExchange logDirectExchange() {
        return new DirectExchange("log.exchange.direct", false, false);
    }

/**
     * 根据路由键绑定队列到交换器上
     *
     * @return
     */

    @Bean
    public Binding logDirectBinding() {
        return BindingBuilder.bind(logDirectQueue()).to(logDirectExchange()).with("logDirectQueue");
    }
}
