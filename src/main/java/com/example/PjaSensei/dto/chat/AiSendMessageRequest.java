package com.example.PjaSensei.dto.chat;

public record AiSendMessageRequest(
        String question,
        SendMessageRequest.CodeContext code_context,
        String client_message_id
) {
}
