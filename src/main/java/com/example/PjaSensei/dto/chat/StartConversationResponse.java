package com.example.PjaSensei.dto.chat;

public record StartConversationResponse(
        String conversation_id,
        boolean prelab_required,
        SenseiConfig.IdeRestrictions ide_restrictions
) {
}
