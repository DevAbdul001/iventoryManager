package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table( name = "payment")
public class Payment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long Id;

    private BigDecimal amount;
    private Long orderId;
    private Long userId;
    private String status;

    protected Payment(){

    }

    public Payment(BigDecimal amount, Long orderId, Long userId, String status ){
        this.amount = amount;
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
    }
}
