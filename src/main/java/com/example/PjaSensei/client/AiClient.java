package com.example.PjaSensei.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class AiClient {
    private final WebClient webClient;

    public Mono<String> getHealth() {
        return webClient.get()
                .uri("/health")
                .retrieve()
                .bodyToMono(String.class);

    }

}
