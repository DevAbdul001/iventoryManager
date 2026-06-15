package com.inventory.app.DTO.InventoryDTO;

import com.inventory.app.Models.Inventory;

public record InventoryDTO(
        Long id,
        Long productId,
        String productName,
        int quantity
) {
    public static InventoryDTO fromEntity(Inventory inventory) {
        return new InventoryDTO(
                inventory.getId(),
                inventory.getProduct().getId(),
                inventory.getProduct().getName(),
                inventory.getQuantity()
        );
    }
}
