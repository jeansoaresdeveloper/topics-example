package com.consumer.example.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME_3 = "queue3";
    public static final String QUEUE_EXCHANGE = "fanoutExchange";

    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_NAME_3, false);
    }


    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(QUEUE_EXCHANGE);
    }

}
