package com.example.PjaSensei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClientBuilder() {
        return WebClient.builder()
                .baseUrl("http://localhost:8000")
                .build(); //TODO: Add url here from properties-when created
    }
}
