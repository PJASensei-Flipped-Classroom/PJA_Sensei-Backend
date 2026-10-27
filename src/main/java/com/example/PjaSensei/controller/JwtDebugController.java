package com.example.PjaSensei.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/debug")
public class JwtDebugController {

    @GetMapping("/jwt")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Object> jwt(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getClaims();
    }
}
