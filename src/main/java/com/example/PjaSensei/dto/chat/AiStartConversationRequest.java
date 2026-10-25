package com.example.PjaSensei.dto.chat;

public record AiStartConversationRequest(
        String problem_description,
        SenseiConfig config
) {
}
