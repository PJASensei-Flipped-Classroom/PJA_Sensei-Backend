package com.example.PjaSensei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AiWebClientConfig {
    private final String aiUrl;

    public AiWebClientConfig(@Value("${ai-properties.ai-url}") String aiUrl) {
        this.aiUrl = aiUrl;
    }

    @Bean
    public WebClient webClientBuilder() {
        return WebClient.builder()
                .baseUrl(aiUrl)
                .build();
    }



}
