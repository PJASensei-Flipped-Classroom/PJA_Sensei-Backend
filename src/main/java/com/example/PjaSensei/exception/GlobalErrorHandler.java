package com.example.PjaSensei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.PjaSensei.exception.ChatValidationException;
import com.example.PjaSensei.exception.ConversationNotFoundException;

import java.time.Instant;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleBadRequest(RuntimeException exception) {
        return ResponseEntity.badRequest().body(new ApiError(Instant.now(), 400, exception.getMessage()));
    }

    @ExceptionHandler(ChatValidationException.class)
    public ResponseEntity<ApiError> handleValidation(ChatValidationException exception) {
        return ResponseEntity.unprocessableContent()
                .body(new ApiError(Instant.now(), 422, exception.getMessage()));
    }

    @ExceptionHandler(ConversationNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ConversationNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(Instant.now(), 404, exception.getMessage()));
    }
}
