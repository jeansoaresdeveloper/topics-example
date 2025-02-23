package com.publisher.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class controller {

    private final Producer producer;

    @GetMapping("/send")
    public String send(@RequestParam final String message) {
        producer.sendMessage(message);
        return "Message sent: " + message;
    }

}
