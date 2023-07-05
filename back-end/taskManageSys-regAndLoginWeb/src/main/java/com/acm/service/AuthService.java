package com.acm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    boolean sendEmail(String email,String sessionId);
}
