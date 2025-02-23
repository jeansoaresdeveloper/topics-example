package com.consumer.example;

import com.consumer.example.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME_3)
    public void listen(String message) {
        System.out.println("Received Message 3: " + message);
    }

}
