package com.springboot.springboottransactiondemo.dto;

import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class JWTRequest {

    private String username;
    private String password;
}
