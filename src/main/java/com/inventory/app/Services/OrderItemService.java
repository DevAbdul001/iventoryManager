package com.inventory.app.Services;

import com.inventory.app.Models.OrderItem;
import com.inventory.app.Repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem createOrderItem(Long orderId, Long productId, BigDecimal price, int quantity){
        OrderItem orderItem = new OrderItem(orderId, productId, price, quantity );
        return orderItemRepository.save(orderItem);
    }
}
