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

}