package com.example.Wayfarer.service;

import com.example.Wayfarer.entities.User;
import com.example.Wayfarer.payloads.AuthRequest;
import com.example.Wayfarer.payloads.AuthResponse;
import com.example.Wayfarer.repositories.UserRepository;
import com.example.Wayfarer.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil; // Assuming you have a JwtUtil class for token generation

    public AuthResponse signUp(User user) {
        // Encode password and save user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // Generate token
        String token = jwtUtil.generateToken(user);

        // Create response
        AuthResponse.Data data = new AuthResponse.Data(token, user.getFirstName(), user.getLastName(), user.getEmail());
        AuthResponse response = new AuthResponse();
        response.setStatus(200);
        response.setData(data);

        return response;
    }

    public AuthResponse signIn(AuthRequest authRequest) {
        Optional<User> optionalUser = userRepository.findByEmail(authRequest.getEmail());

        if (optionalUser.isEmpty()) {
            return new AuthResponse(401, "User not found", null);
        }

        User user = optionalUser.get();

        // Check password
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            return new AuthResponse(401, "Invalid credentials", null);
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user);

        // Create response
        AuthResponse.Data data = new AuthResponse.Data(token, user.getFirstName(), user.getLastName(), user.getEmail());
        AuthResponse response = new AuthResponse();
        response.setStatus(200);
        response.setData(data);

        return response;
    }

    public String authenticateUser(AuthRequest request) {
        Optional<User> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent() && passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            return "Authentication successful";
        }
        return "Invalid credentials";
    }
}
