package com.websocket.example.service;

import com.websocket.example.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public void notifyCreatedUser(final User user) {
        messagingTemplate.convertAndSend("/topic/user-created", user);
    }
}
