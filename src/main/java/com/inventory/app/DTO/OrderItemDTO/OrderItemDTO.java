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
                orderItem.getOrderId(),
                orderItem.getProductId(),
                orderItem.getPrice(),
                orderItem.getQuantity(),
                orderItem.getItem().getName(),
                orderItem.getItem().getImg_url()
        );
    }
}
