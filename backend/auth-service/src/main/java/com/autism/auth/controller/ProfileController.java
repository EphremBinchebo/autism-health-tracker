package com.autism.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @GetMapping("/me")
    public ResponseEntity<String> getProfile(Authentication authentication) {
        return ResponseEntity.ok("Hello, " + authentication.getName());
    }
}