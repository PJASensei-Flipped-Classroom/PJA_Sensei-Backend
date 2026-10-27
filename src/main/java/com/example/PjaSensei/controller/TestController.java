package com.example.PjaSensei.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/public/test")
    @PreAuthorize("hasRole('ADMIN')")
    public String test() {
        return "Test";
    }
}
