package com.example.PjaSensei.controller;

import com.example.PjaSensei.service.AiHealthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import tools.jackson.databind.JsonNode;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AiHealthController {
    private final AiHealthService aiHealthService;

    @GetMapping("/health")
    public Mono<ResponseEntity<JsonNode>> getAiHealth() {
        return aiHealthService.getAiHealth();
    }

    @GetMapping("/healthz")
    public Mono<ResponseEntity<JsonNode>> getAiHealthz() {
        return aiHealthService.getAiHealthz();
    }

    @GetMapping("/metrics")
    public Mono<ResponseEntity<JsonNode>> getAiMetrics() {
        return aiHealthService.getAiMetrics();
    }

    @GetMapping("/metrics/prometheus")
    public Mono<ResponseEntity<String>> getAiMetricsPrometheus() {
        return aiHealthService.getAiPrometheus();
    }
}
