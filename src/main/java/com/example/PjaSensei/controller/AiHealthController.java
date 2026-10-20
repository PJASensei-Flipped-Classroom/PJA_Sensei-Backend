package com.example.PjaSensei.controller;

import com.example.PjaSensei.service.AiHealthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AiHealthController {
    private final AiHealthService aiHealthService;

    @GetMapping("/health")
    public Mono<String> getAiHealth() {
        return aiHealthService.getAiHealth();
    }

    @GetMapping("/healthz")
    public Mono<String> getAiHealthz() {
        return aiHealthService.getAiHealthz();
    }

    @GetMapping("/metrics")
    public Mono<String> getAiMetrics() {
        return aiHealthService.getAiMetrics();
    }

    @GetMapping("/metrics/prometheus")
    public Mono<String> getAiMetricsPrometheus() {
        return aiHealthService.getAiPrometheus();
    }
}
