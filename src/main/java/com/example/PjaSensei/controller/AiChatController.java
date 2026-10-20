package com.example.PjaSensei.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;

@AllArgsConstructor
@RestController
@RequestMapping("/ai")
public class AiChatController {

    @PostMapping("/conversation")
    public ResponseEntity<JsonNode> createAiConversation() {
        // Implement the logic to handle the conversation with the AI model
        // For now, return a placeholder response
        JsonNode placeholderResponse = null; // Replace with actual response from AI model
        return ResponseEntity.ok(placeholderResponse);
    }
}
