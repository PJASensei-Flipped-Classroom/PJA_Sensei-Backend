package com.example.PjaSensei.service;

import com.example.PjaSensei.client.AiClient;
import com.example.PjaSensei.dto.chat.AiSendMessageRequest;
import com.example.PjaSensei.dto.chat.SendMessageRequest;
import com.example.PjaSensei.dto.chat.SendMessageResponse;
import com.example.PjaSensei.exception.ChatValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final SessionService sessionService;
    private final AiClient aiClient;

    public SendMessageResponse send(String conversationId, SendMessageRequest request) {
        validate(request);
        sessionService.requireOwnedBy(conversationId, request.userSub(), request.repoId());
        return aiClient.sendMessage(conversationId, new AiSendMessageRequest(
                request.question(), request.code_context(), request.client_message_id()));
    }

    private void validate(SendMessageRequest request) {
        if (request == null || isBlank(request.userSub())) {
            throw new ChatValidationException("userSub is required");
        }
        if (isBlank(request.repoId())) {
            throw new ChatValidationException("repoId is required");
        }
        if (isBlank(request.question())) {
            throw new ChatValidationException("question is required");
        }
        if (request.code_context() == null) {
            throw new ChatValidationException("code_context is required");
        }
        if (isBlank(request.code_context().current_file_name())) {
            throw new ChatValidationException("code_context.current_file_name is required");
        }
        if (request.code_context().current_code() == null) {
            throw new ChatValidationException("code_context.current_code is required");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
