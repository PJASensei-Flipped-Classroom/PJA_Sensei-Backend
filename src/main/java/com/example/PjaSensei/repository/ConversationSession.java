package com.example.PjaSensei.repository;

import com.example.PjaSensei.dto.chat.StartConversationResponse;

public record ConversationSession(
        String userSub,
        String repoId,
        String taskId,
        StartConversationResponse response
) {
}
