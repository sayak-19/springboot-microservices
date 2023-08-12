package com.springboot.springboottransactiondemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OrderResponse {

    private String orderTrackingNbr;
    private String status;
    private String message;
}
