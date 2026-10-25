package com.example.PjaSensei.repository;

public interface ConversationSessionRepository {
    void save(ConversationSession session);

    ConversationSession findRequired(String conversationId, String userSub, String repoId);
}
