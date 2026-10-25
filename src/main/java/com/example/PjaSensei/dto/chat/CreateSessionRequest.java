package com.example.PjaSensei.dto.chat;

public record CreateSessionRequest(
        String userSub,
        String repoId,
        String taskId,
        String problem_description,
        SenseiConfig config
) {
}
