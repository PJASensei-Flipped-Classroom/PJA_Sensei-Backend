package com.example.PjaSensei.dto.chat;

import java.util.List;

public record SendMessageResponse(
        String message_id,
        String answer,
        Integer prompt_score,
        String prompt_feedback,
        Integer tokens_used,
        Boolean is_cached,
        Boolean penalty_applied,
        List<String> sources,
        String suggested_next_step,
        List<GoalProgress> goal_progress,
        NextCheckpoint next_checkpoint,
        DebugInfo debug_info,
        String model,
        String client_message_id
) {
    public record GoalProgress(String goal, String status) {
    }

    public record NextCheckpoint(String id, String hint, String after_goal) {
    }

    public record DebugInfo(Boolean is_frustrated, Double avg_score, Boolean code_changed) {
    }
}
