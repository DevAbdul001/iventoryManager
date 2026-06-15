package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table( name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;

    private Long orderId;
    private Long productId;
    private BigDecimal price;
    private int quantity;

    protected OrderItem(){

    }

    public OrderItem(Long orderId, Long productId, BigDecimal price, int quantity){

        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
