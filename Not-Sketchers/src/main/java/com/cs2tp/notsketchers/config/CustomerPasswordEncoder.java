package com.cs2tp.notsketchers.config;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomerPasswordEncoder implements PasswordEncoder {

    private final int strength;

    public CustomerPasswordEncoder(int strength) {
        this.strength = strength;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        // encode the raw password using BCrypt algorithm
        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(strength));
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // decode the encoded password and compare it with the raw password
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }
}
