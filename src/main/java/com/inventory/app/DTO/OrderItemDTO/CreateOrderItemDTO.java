package com.inventory.app.DTO.OrderItemDTO;

import java.math.BigDecimal;

public record CreateOrderItemDTO(
        Long orderId,
        Long productId,
        int quantity
) {}
