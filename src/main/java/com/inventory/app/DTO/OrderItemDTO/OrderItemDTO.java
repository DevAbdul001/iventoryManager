package com.inventory.app.DTO.OrderItemDTO;

import com.inventory.app.Models.OrderItem;

import java.math.BigDecimal;

public record OrderItemDTO (
        Long orderId,
        Long productId,
        BigDecimal price,
        int quantity,
        String productName,
        String img_url
) {
    public static OrderItemDTO fromEntity(OrderItem orderItem){
        return new OrderItemDTO(
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId(),
                orderItem.getPrice(),
                orderItem.getQuantity(),
                orderItem.getProduct().getName(),
                orderItem.getProduct().getImg_url()
        );
    }
}
