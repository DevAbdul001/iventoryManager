package com.inventory.app.Services;

import com.inventory.app.Models.Order;
import com.inventory.app.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Long userId, BigDecimal total, String status){
            Order order = new Order (userId, total, status);
            return orderRepository.save(order);
    }
}
