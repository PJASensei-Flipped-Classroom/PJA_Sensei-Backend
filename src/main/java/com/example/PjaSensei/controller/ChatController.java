package com.example.PjaSensei.controller;

import com.example.PjaSensei.dto.chat.CreateSessionRequest;
import com.example.PjaSensei.dto.chat.SendMessageRequest;
import com.example.PjaSensei.dto.chat.SendMessageResponse;
import com.example.PjaSensei.dto.chat.StartConversationResponse;
import com.example.PjaSensei.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversations")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<StartConversationResponse> startConversation(
            @RequestBody CreateSessionRequest request) {
        return ResponseEntity.ok(chatService.startSession(request));
    }

    @PostMapping("/{conversationId}/messages")
    public ResponseEntity<SendMessageResponse> sendMessage(
            @PathVariable String conversationId,
            @RequestBody SendMessageRequest request) {
        return ResponseEntity.ok(chatService.sendMessage(conversationId, request));
    }
}
