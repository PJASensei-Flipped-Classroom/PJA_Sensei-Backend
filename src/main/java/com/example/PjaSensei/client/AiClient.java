package com.example.PjaSensei.client;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.JsonNode;

@Component
@AllArgsConstructor
public class AiClient {
    private final RestClient restClient;

    public ResponseEntity<JsonNode> getHealth() {
        return restClient.get()
                .uri("/health")
                .retrieve()
                .toEntity(JsonNode.class);
    }

    public ResponseEntity<JsonNode> getHealthz() {
        return restClient.get()
                .uri("/healthz")
                .retrieve()
                .toEntity(JsonNode.class);
    }

    public ResponseEntity<JsonNode> getMetrics() {
        return restClient.get()
                .uri("/metrics")
                .retrieve()
                .toEntity(JsonNode.class);
    }

    public ResponseEntity<String> getAiPrometheus() {
        return restClient.get()
                .uri("/metrics/prometheus")
                .retrieve()
                .toEntity(String.class);
    }
}