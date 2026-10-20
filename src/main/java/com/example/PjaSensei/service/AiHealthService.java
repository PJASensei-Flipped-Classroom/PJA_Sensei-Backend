package com.example.PjaSensei.service;

import com.example.PjaSensei.client.AiClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import tools.jackson.databind.JsonNode;

@Service
@AllArgsConstructor
public class AiHealthService {
    private final AiClient aiClient;

    public Mono<ResponseEntity<JsonNode>> getAiHealth() {
        return aiClient.getHealth()
                .onErrorResume(e -> Mono.<ResponseEntity<JsonNode>>just(ResponseEntity.status(500).body())); //TODO: zmienic
    }

    public Mono<String> getAiHealthz() {
        return aiClient.getHealthz()
                .onErrorResume(e -> Mono.just("AI service is down: "));
    }

    public Mono<String> getAiMetrics() {
        return aiClient.getMetrics()
                .onErrorResume(e -> Mono.just("AI service metrics are not available: "));
    }

    public Mono<String> getAiPrometheus() {
        return aiClient.getAiPrometheus()
                .onErrorResume(e -> Mono.just("Prometheus metrics are not available: "));
    }
}
