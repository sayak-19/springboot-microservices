package com.springboot.springboottransactiondemo.service;

import com.springboot.springboottransactiondemo.dto.OrderDTO;
import com.springboot.springboottransactiondemo.dto.OrderRequest;
import com.springboot.springboottransactiondemo.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);

    List<OrderDTO> getAllOrders();
}
