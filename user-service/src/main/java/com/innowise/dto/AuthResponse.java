package com.innowise.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponse {

    private UUID userId;
    private String userEmail;
    private String userName;
    private Set<String> userRole;

}
