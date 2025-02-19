package com.example.Wayfarer.controllers;

import com.example.Wayfarer.entities.User;
import com.example.Wayfarer.payloads.AuthRequest;
import com.example.Wayfarer.service.AuthService;
import com.example.Wayfarer.payloads.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signUp(@RequestBody User user) {
        AuthResponse response = authService.signUp(user);
        return ResponseEntity.status(response.getStatus()).body(response);
    }




    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signIn(@RequestBody AuthRequest authRequest) {
        AuthResponse response = authService.signIn(authRequest);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
