package com.example.PjaSensei.service;

import com.example.PjaSensei.dto.chat.CreateSessionRequest;
import com.example.PjaSensei.dto.chat.SendMessageRequest;
import com.example.PjaSensei.dto.chat.SendMessageResponse;
import com.example.PjaSensei.dto.chat.StartConversationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final SessionService sessionService;
    private final MessageService messageService;

    public StartConversationResponse startSession(CreateSessionRequest request) {
        return sessionService.create(request);
    }

    public SendMessageResponse sendMessage(String conversationId, SendMessageRequest request) {
        return messageService.send(conversationId, request);
    }
}
