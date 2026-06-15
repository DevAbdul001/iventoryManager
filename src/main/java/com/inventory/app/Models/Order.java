package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table( name = "orders")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    private  Long userId;
    private BigDecimal total;
    private String status;

    protected Order(){

    }

    public Order( Long userId, BigDecimal total, String status){
        this.userId = userId;
        this.total = total;
        this.status = status;
    }


}
