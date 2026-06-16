package com.inventory.app.DTO.OrderDTO;

import java.math.BigDecimal;

public record CreateOrderDTO(
        Long userId,
        BigDecimal total
) {}
