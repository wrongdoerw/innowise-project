//package com.innowise.controller;
//
//import com.innowise.dto.AuthRequest;
//import com.innowise.dto.AuthResponse;
//import com.innowise.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final UserService userService;
//
//    @PostMapping("/auth")
//    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
//        return ResponseEntity.ok(userService.auth(authRequest));
//    }
//
//}
