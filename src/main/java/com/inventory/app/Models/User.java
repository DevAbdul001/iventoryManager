package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table( name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    protected  User(){

    }

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }
}
