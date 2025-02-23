package com.publisher.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate template;

    public void sendMessage(final String message) {
        template.convertAndSend("fanoutExchange", "", message);
    }

}
