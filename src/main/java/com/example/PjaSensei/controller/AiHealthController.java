package com.example.PjaSensei.controller;

import com.example.PjaSensei.service.AiHealthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/health")
@AllArgsConstructor
public class AiHealthController {
    private final AiHealthService aiHealthService;

    @GetMapping
    public Mono<String> getAiHealth() {
        return aiHealthService.getAiHealth();
    }
}
