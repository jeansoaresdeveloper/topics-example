package com.publisher.example.service;

import com.publisher.example.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME_1)
    public void listen(String message) {
        System.out.println("Received Message 1: " + message);
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME_2)
    public void listen2(String message) {
        System.out.println("Received Message 2: " + message);
    }

}
