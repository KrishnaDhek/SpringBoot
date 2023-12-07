package com.springboot.chat.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    // Enum defining the type of the chat message (JOIN, LEAVE, CHAT).
    private MessageType type;

    // Content of the chat message.
    private String content;

    // Sender of the chat message.
    private String sender;

}