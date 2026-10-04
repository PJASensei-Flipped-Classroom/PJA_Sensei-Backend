package com.example.PjaSensei.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChatService {
    private final WebClient aiClient;

    public ChatService(WebClient.Builder builder) {
        this.aiClient = builder
                .baseUrl("http://localhost:8000")
                .build();
    }

    public Mono<String> getHealth() {
        return aiClient.get()
                .uri("/health")
                .retrieve()
                .bodyToMono(String.class);
    }

}
