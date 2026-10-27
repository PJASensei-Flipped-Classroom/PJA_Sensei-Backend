package com.example.PjaSensei.dto.chat;

public record SendMessageRequest(
        String repoId,
        String question,
        CodeContext code_context,
        String client_message_id
) {
    public record CodeContext(
            String current_file_name,
            String current_code,
            String error_logs
    ) {
    }
}
