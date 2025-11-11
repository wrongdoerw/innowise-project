package com.innowise.service;

import com.innowise.dto.AuthRequest;
import com.innowise.dto.AuthResponse;
import com.innowise.dto.RegisterRequest;
import com.innowise.dto.RegisterResponse;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    public RegisterResponse register(RegisterRequest registerRequest) {

        // TODO проверка существует ли такое мыло
        // и существует ли такой логин

        RegisterResponse registerResponse = new RegisterResponse();

        UUID userId = UUID.randomUUID();
        String userName = registerRequest.getUserName();
        String userEmail = registerRequest.getUserEmail();
        Set<String> userRoles = Set.of("USER");

        registerResponse.setUserId(userId);
        registerResponse.setUserName(userName);
        registerResponse.setUserEmail(userEmail);
        registerResponse.setUserRoles(userRoles);

        return registerResponse;

    }


    // TODO after DB
    public AuthResponse auth(AuthRequest authRequest) {

        AuthResponse authResponse = new AuthResponse();

        UUID userId;
        String userEmail;
        String userName;
        Set<String> userRole;

        return authResponse;

    }
}
