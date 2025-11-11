package com.innowise.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String userName;
    private String userEmail;
    private String userPassword;
    private String userPasswordConfirm;

}
