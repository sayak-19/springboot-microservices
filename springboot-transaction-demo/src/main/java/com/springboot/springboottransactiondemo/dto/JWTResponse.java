package com.springboot.springboottransactiondemo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JWTResponse {

    private String jwtToken;
    private String username;
}
