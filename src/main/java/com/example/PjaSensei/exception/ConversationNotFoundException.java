package com.example.PjaSensei.exception;

public class ConversationNotFoundException extends RuntimeException {
    public ConversationNotFoundException(String conversationId) {
        super("Unknown conversation: " + conversationId);
    }
}
