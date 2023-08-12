package com.springboot.springboottransactiondemo.service.impl;

import com.springboot.springboottransactiondemo.dto.OrderDTO;
import com.springboot.springboottransactiondemo.dto.OrderRequest;
import com.springboot.springboottransactiondemo.dto.OrderResponse;
import com.springboot.springboottransactiondemo.entity.Order;
import com.springboot.springboottransactiondemo.entity.Payment;
import com.springboot.springboottransactiondemo.exception.PaymentException;
import com.springboot.springboottransactiondemo.repository.OrderRepository;
import com.springboot.springboottransactiondemo.repository.PaymentRepository;
import com.springboot.springboottransactiondemo.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        orderRepository.save(order);

        Payment  payment = orderRequest.getPayment();
        if(!payment.getType().equals("DEBIT"))
            throw new PaymentException("Payment card type is not supported");

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNbr(order.getOrderTrackingNumber());
        orderResponse.setMessage("SUCCESS");
        orderResponse.setStatus(order.getStatus());
        return orderResponse;
    }

    @Override
    public List<OrderDTO> getAllOrders() {

        List<Order> orderList = orderRepository.findAll();

        List<OrderDTO> orderDTOS= new ArrayList<>();
        for (Order order : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(order, orderDTO);
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
}
