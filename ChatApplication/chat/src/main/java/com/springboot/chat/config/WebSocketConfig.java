package com.springboot.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


//@Configuration annotation indicates that this class is a configuration class for the
// Spring application context.
@Configuration

//@EnableWebSocketMessageBroker is used to enable WebSocket message handling,
// backed by a message broker.
@EnableWebSocketMessageBroker
//WebSocketMessageBrokerConfigurer is an interface that provides methods to configure
// WebSocket message handling with a message broker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //registerStompEndpoints method configures STOMP (Simple Text Oriented Messaging Protocol) endpoints,
    // allowing clients to connect to the WebSocket.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //addEndpoint("/ws") endpoint ("/ws") is the entry point for WebSocket connections.
        //withSockJS() enables SockJS fallback options for browsers that do not support WebSocket natively.
        registry.addEndpoint("/ws").withSockJS();
    }

    //configureMessageBroker method configures the message broker.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //setApplicationDestinationPrefixes("/app") defines the prefix for messages that
        // are bound for methods annotated with @MessageMapping.

        registry.setApplicationDestinationPrefixes("/app");

        //enableSimpleBroker("/topic") enables a simple in-memory message broker that broadcasts
        // messages to topics. In this case, messages sent to "/topic" will be broadcasted to all
        // connected clients

        registry.enableSimpleBroker("/topic");
    }
}