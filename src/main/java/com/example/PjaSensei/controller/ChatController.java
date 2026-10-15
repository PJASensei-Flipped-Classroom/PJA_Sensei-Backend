package com.example.PjaSensei.controller;

import com.example.PjaSensei.service.ChatService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ChatController {
    public final ChatService chatService;





//    @PostMapping("/chat")
//    public Mono<JsonNode> chat(@RequestBody JsonNode body) {
//        return chatService.aiClient.post()
//                .uri("/conversations/{id}/messages", body.get("conversationId").asText())
//                .bodyValue(Map.of(
//                        "message", body.get("message").asText()
//                ))
//                .retrieve()
//                .bodyToMono(JsonNode.class);
//    }
}
