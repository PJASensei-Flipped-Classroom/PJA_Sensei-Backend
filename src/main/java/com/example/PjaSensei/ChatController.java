package com.example.PjaSensei;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ChatController {
    private final WebClient aiClient;

    public ChatController(WebClient.Builder builder) {
        this.aiClient = builder
                .baseUrl("http://localhost:8000")
                .build();
    }

    @PostMapping("/chat")
    public Mono<JsonNode> chat(@RequestBody JsonNode body) {
        return aiClient.post()
                .uri("/conversations/{id}/messages", body.get("conversationId").asText())
                .bodyValue(Map.of(
                        "message", body.get("message").asText()
                ))
                .retrieve()
                .bodyToMono(JsonNode.class);
    }
}
