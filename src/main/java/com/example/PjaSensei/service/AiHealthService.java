package com.example.PjaSensei.service;

import com.example.PjaSensei.client.AiClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
@AllArgsConstructor
public class AiHealthService {
    private final AiClient aiClient;

    public ResponseEntity<JsonNode> getAiHealth() {
        return aiClient.getHealth();
    }

    public ResponseEntity<JsonNode> getAiHealthz() {
        return aiClient.getHealthz();
    }

    public ResponseEntity<JsonNode> getAiMetrics() {
        return aiClient.getMetrics();
    }

    public ResponseEntity<String> getAiPrometheus() {
        return aiClient.getAiPrometheus();
    }
}