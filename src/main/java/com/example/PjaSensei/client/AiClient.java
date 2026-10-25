package com.example.PjaSensei.client;

import com.example.PjaSensei.dto.chat.AiSendMessageRequest;
import com.example.PjaSensei.dto.chat.AiStartConversationRequest;
import com.example.PjaSensei.dto.chat.SendMessageResponse;
import com.example.PjaSensei.dto.chat.StartConversationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
public class AiClient {
    private final RestClient restClient;

    public StartConversationResponse startConversation(AiStartConversationRequest request) {
        return restClient.post()
                .uri("/conversations")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(StartConversationResponse.class);
    }

    public SendMessageResponse sendMessage(String conversationId, AiSendMessageRequest request) {
        return restClient.post()
                .uri("/conversations/{conversationId}/messages", conversationId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(SendMessageResponse.class);
    }
}