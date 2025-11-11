package com.innowise.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    // TODO сделать возможность авторизироваться
    // через мыло или через юзернейм
    private String userEmail;
    private String userPassword;

}
