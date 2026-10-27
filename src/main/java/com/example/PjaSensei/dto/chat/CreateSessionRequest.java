package com.example.PjaSensei.dto.chat;

public record CreateSessionRequest(
        String repoId,
        String taskId,
        String problem_description,
        SenseiConfig config
) {
}
