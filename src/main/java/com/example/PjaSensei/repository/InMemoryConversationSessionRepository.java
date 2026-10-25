package com.example.PjaSensei.repository;

import com.example.PjaSensei.exception.ConversationNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryConversationSessionRepository implements ConversationSessionRepository {
    private final Map<String, ConversationSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void save(ConversationSession session) {
        sessions.put(session.response().conversation_id(), session);
    }

    @Override
    public ConversationSession findRequired(String conversationId, String userSub, String repoId) {
        ConversationSession session = sessions.get(conversationId);
        if (session == null
                || !session.userSub().equals(userSub)
                || !session.repoId().equals(repoId)) {
            throw new ConversationNotFoundException(conversationId);
        }
        return session;
    }
}
