package com.inventory.app.DTO.UserDTO;

public record UpdateUserDTO(
        Long id,
        String username,
        String email
) {
}
