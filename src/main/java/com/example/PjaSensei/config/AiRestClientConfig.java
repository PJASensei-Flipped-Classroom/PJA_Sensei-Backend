package com.example.PjaSensei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AiRestClientConfig {
    private final String aiUrl;

    public AiRestClientConfig(@Value("${ai-properties.ai-url}") String aiUrl) {
        this.aiUrl = aiUrl;
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl(aiUrl)
                .build();
    }
}

