package com.inventory.app.DTO.ProductDTO;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String name,
        String description,
        String img_url,
        BigDecimal price
) {}
