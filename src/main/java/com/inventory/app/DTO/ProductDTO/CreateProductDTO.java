package com.inventory.app.DTO.ProductDTO;

import java.math.BigDecimal;

public record CreateProductDTO(
        String name,
        String description,
        String img_url,
        BigDecimal price
) {}
