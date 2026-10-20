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
                .retrieve()
                .toEntity(JsonNode.class);
    }

    public Mono<String> getHealthz() {
        return webClient.get()
                .uri("/healthz")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getMetrics() {
        return webClient.get()
                .uri("/metrics")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<String> getAiPrometheus() {
        return webClient.get()
                .uri("/metrics/prometheus")
                .retrieve()
                .bodyToMono(String.class);
    }
}
