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

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product item;

    protected OrderItem(){

    }

    public OrderItem(Product  product, Order order, int quantity){

        this.orderId = order.getId();
        this.productId = product.getId();
        this.price =  product.getPrice();
        this.quantity = quantity;
    }
}
