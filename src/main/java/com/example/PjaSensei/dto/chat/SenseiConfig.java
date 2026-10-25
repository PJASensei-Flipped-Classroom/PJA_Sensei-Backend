package com.example.PjaSensei.dto.chat;

import java.util.List;

public record SenseiConfig(
        LearningContext learningContext,
        AgentBehavior agentBehavior,
        String language,
        IdeRestrictions ideRestrictions,
        PreLab preLab,
        List<Checkpoint> checkpoints,
        List<String> evaluationCriteria,
        Integer maxTokensPerSession
) {
    public record LearningContext(List<String> goals, List<String> referenceMaterials) {
    }

    public record AgentBehavior(Persona persona, List<String> strictRules, String mode) {
    }

    public record Persona(String role, String tone) {
    }

    public record IdeRestrictions(Boolean requireFileContextForChat, Boolean disableCopyFromChat) {
    }

    public record PreLab(Boolean enabled, List<PreLabQuestion> questions) {
    }

    public record PreLabQuestion(String id, String question) {
    }

    public record Checkpoint(String id, String afterGoal, String hint) {
    }
}
