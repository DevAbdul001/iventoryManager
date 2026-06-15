package com.inventory.app.Controllers;

import com.inventory.app.DTO.UserDTO.CreateUserDTO;
import com.inventory.app.DTO.UserDTO.UserResponse;
import com.inventory.app.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@RequestBody CreateUserDTO dto){
        return  userService.createUser(dto);
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(
            @PathVariable Long userId
    ){
        return userService.getUserById(userId);
    }
}
