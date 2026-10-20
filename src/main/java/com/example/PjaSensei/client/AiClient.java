package com.example.PjaSensei.client;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tools.jackson.databind.JsonNode;

@Component
@AllArgsConstructor
public class AiClient {
    private final WebClient webClient;

    public Mono<ResponseEntity<JsonNode>> getHealth() {
        return webClient.get()
                .uri("/health")
                .exchangeToMono(response -> response.toEntity(JsonNode.class));
    }

    public Mono<ResponseEntity<JsonNode>> getHealthz() {
        return webClient.get()
                .uri("/healthz")
                .exchangeToMono(response -> response.toEntity(JsonNode.class));
    }

    public Mono<ResponseEntity<JsonNode>> getMetrics() {
        return webClient.get()
                .uri("/metrics")
                .exchangeToMono(response -> response.toEntity(JsonNode.class));
    }

    public Mono<ResponseEntity<String>> getAiPrometheus() {
        return webClient.get()
                .uri("/metrics/prometheus")
                .exchangeToMono(response -> response.toEntity(String.class));
    }
}
