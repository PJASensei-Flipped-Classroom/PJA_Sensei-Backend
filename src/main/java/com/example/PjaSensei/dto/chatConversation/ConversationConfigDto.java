package com.example.PjaSensei.dto.chatConversation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ConversationConfigDto(
        String language,
        LearningContext learningContext,
        AgentBehavior agentBehavior,
        IdeRestrictions ideRestrictions,
        List<String> evaluationCriteria,
        List<Checkpoint> checkpoints
) {

    public record LearningContext(
            List<String> goals,
            List<ReferenceMaterial> referenceMaterials
    ) {}

    public record ReferenceMaterial(String type, String title, String url) {}

    public record AgentBehavior(
            Persona persona,
            List<String> strictRules,
            String mode,
            String codeRevealFallback
    ) {}

    public record Persona(String role, String tone) {}

    public record IdeRestrictions(
            boolean requireFileContextForChat,
            boolean disableCopyFromChat
    ) {}

    public record Checkpoint(
            String id,
            @JsonProperty("after_goal") String afterGoal,
            String hint
    ) {}

}
