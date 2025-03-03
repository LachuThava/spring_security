package com.service.auth.Util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class EncoderCommon {

    private final PasswordEncoder passwordEncoder;

    public EncoderCommon(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static String encodePasswordStrength5(String password) {
        return new BCryptPasswordEncoder(5, new SecureRandom()).encode(password);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}