package com.springboot.chat.config;


import com.springboot.chat.chat.ChatMessage;
import com.springboot.chat.chat.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

    // Injecting SimpMessageSendingOperations for sending messages to WebSocket clients.
    private final SimpMessageSendingOperations messagingTemplate;

    // Event listener for handling WebSocket session disconnect events
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // Extracting session attributes using StompHeaderAccessor.
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        // Checking if a username is available (user was authenticated).
        if (username != null) {
            // Logging user disconnection.
            log.info("user disconnected: {}", username);
            // Creating a ChatMessage of type LEAVE to broadcast to clients.
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();

            // Broadcasting the LEAVE message to "/topic/public".
            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }

}