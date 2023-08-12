package com.example.todo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {

    public static void main(String[] args) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //System.out.println(passwordEncoder.encode("1234"));
        System.out.println(passwordEncoder.encode("admin"));
    }
}
