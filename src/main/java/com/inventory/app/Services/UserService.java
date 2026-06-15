package com.inventory.app.Services;

import com.inventory.app.DTO.UserDTO.CreateUserDTO;
import com.inventory.app.DTO.UserDTO.UserResponse;
import com.inventory.app.Models.User;
import com.inventory.app.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   public UserResponse createUser(CreateUserDTO dto){
        User user = new User(
                dto.username(),
                dto.email()
        );

        userRepository.save(user);
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
   }

   public UserResponse getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
   }
}
