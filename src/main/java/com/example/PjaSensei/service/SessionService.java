package com.example.PjaSensei.service;

import com.example.PjaSensei.client.AiClient;
import com.example.PjaSensei.dto.chat.AiStartConversationRequest;
import com.example.PjaSensei.dto.chat.CreateSessionRequest;
import com.example.PjaSensei.dto.chat.StartConversationResponse;
import com.example.PjaSensei.exception.ChatValidationException;
import com.example.PjaSensei.repository.ConversationSession;
import com.example.PjaSensei.repository.ConversationSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final AiClient aiClient;
    private final ConversationSessionRepository sessionRepository;

    public StartConversationResponse create(CreateSessionRequest request) {
        validate(request);
        StartConversationResponse response = aiClient.startConversation(
                new AiStartConversationRequest(request.problem_description(), request.config()));
        if (response == null || response.conversation_id() == null
                || response.conversation_id().isBlank()) {
            throw new IllegalStateException("AI service returned an invalid conversation response");
        }
        sessionRepository.save(new ConversationSession(
                request.userSub(), request.repoId(), request.taskId(), response));
        return response;
    }

    public void requireOwnedBy(String conversationId, String userSub, String repoId) {
        sessionRepository.findRequired(conversationId, userSub, repoId);
    }

    private void validate(CreateSessionRequest request) {
        if (request == null || isBlank(request.userSub())) {
            throw new ChatValidationException("userSub is required");
        }
        if (isBlank(request.repoId())) {
            throw new ChatValidationException("repoId is required");
        }
        if (isBlank(request.taskId())) {
            throw new ChatValidationException("taskId is required");
        }
        if (isBlank(request.problem_description())) {
            throw new ChatValidationException("problem_description is required");
        }
        if (request.config() == null || request.config().learningContext() == null
                || request.config().learningContext().goals() == null
                || request.config().learningContext().goals().isEmpty()) {
            throw new ChatValidationException("config.learningContext.goals must contain at least one goal");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
