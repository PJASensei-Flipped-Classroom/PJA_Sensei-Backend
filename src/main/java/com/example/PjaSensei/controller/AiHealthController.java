package com.example.PjaSensei.controller;

import com.example.PjaSensei.service.AiHealthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;

@RestController
@RequestMapping("/ai")
@AllArgsConstructor
public class AiHealthController {
    private final AiHealthService aiHealthService;

    @GetMapping("/health")
    public ResponseEntity<JsonNode> getAiHealth() {
        return aiHealthService.getAiHealth();
    }

    @GetMapping("/healthz")
    public ResponseEntity<JsonNode> getAiHealthz() {
        return aiHealthService.getAiHealthz();
    }

    @GetMapping("/metrics")
    public ResponseEntity<JsonNode> getAiMetrics() {
        return aiHealthService.getAiMetrics();
    }

    @GetMapping("/metrics/prometheus")
    public ResponseEntity<String> getAiMetricsPrometheus() {
        return aiHealthService.getAiPrometheus();
    }
}