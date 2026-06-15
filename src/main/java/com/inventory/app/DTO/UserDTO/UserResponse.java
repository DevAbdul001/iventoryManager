package com.inventory.app.DTO.UserDTO;

public record UserResponse(
        Long Id,
        String username,
        String email
) {
}
