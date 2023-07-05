package com.acm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    String  sendEmail(String email,String sessionId);
    String testRegister(String username,String password,String email,String code,String sessionId);
}
