package com.inventory.app.DTO.OrderDTO;

import java.math.BigDecimal;

public record OrderDTO(
        Long id,
        Long userId,
        BigDecimal total,
        String status
) {}
