package com.example.Wayfarer.utils;

import java.util.Base64;
import java.security.SecureRandom;

public class JWTSecretGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[64];
        random.nextBytes(key);
        String secretKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated JWT Secret Key: " + secretKey);
    }
}
