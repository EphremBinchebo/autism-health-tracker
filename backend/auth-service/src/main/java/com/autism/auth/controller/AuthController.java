package com.autism.auth.controller;

import com.autism.auth.dto.LoginRequest;
import com.autism.auth.dto.RegisterRequest;
import com.autism.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String token = authService.registerUser(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        String token = authService.loginUser(email, password);

        // Create a response map
        Map<String, String> response = new HashMap<>();
        response.put("email", email);
        response.put("password", password);
        response.put("token", token);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/login")
    public ResponseEntity<String> loginViaGet(
            @RequestParam String email,
            @RequestParam String password) {
        String token = authService.loginUser(email, password);
        return ResponseEntity.ok(token);
    }


}

