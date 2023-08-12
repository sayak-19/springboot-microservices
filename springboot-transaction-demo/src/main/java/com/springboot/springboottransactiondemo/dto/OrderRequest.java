package com.springboot.springboottransactiondemo.dto;

import com.springboot.springboottransactiondemo.entity.Order;
import com.springboot.springboottransactiondemo.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OrderRequest {

    private Order order;
    private Payment payment;
}
