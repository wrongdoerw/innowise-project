package com.innowise.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RegisterResponse {

    private UUID userId;
    private String userName;
    private String userEmail;
    private Set<String> userRoles;

}