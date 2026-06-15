package com.inventory.app.DTO.InventoryDTO;

import java.math.BigDecimal;

public record CreateInventoryDTO(
        Long productId,
        int quantity
) {}
