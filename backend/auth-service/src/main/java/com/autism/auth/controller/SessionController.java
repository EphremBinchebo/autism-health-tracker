package com.autism.auth.controller;

import com.autism.auth.model.Session;
import com.autism.auth.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PostMapping
    public Session saveSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @GetMapping("/user/{userId}")
    public List<Session> getUserSessions(@PathVariable Long userId) {
        return sessionService.getUserSessions(userId);
    }
}
