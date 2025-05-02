package com.autism.auth.service;

import com.autism.auth.model.Session;
import com.autism.auth.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> getUserSessions(Long userId) {
        return sessionRepository.findByUserId(userId);
    }
}
