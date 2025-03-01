package com.publisher.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME_1 = "queue1";
    public static final String QUEUE_NAME_2 = "queue2";
    public static final String QUEUE_EXCHANGE = "fanoutExchange";

    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_NAME_1, false);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_NAME_2, false);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(QUEUE_EXCHANGE);
    }

    @Bean
    public Binding bindingOne(FanoutExchange fanoutExchange, @Qualifier("queueOne") Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingTwo(FanoutExchange fanoutExchange, @Qualifier("queueTwo") Queue queue) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
