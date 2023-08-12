package com.springboot.springboottransactiondemo.repository;

import com.springboot.springboottransactiondemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
