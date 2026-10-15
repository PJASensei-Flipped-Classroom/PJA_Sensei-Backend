package com.example.PjaSensei.service;

import com.example.PjaSensei.client.AiClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AiHealthService {
    private final AiClient aiClient;

    public Mono<String> getAiHealth() {
        return aiClient.getHealth()
                .onErrorResume(e -> Mono.just("AI service is down: "));
    }
}
