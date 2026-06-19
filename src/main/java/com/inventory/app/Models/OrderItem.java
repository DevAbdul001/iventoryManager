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

    private BigDecimal price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    protected OrderItem(){

    }

    public OrderItem(Product  product, Order order, int quantity){

        this.order = order;
        this.product = product;
        this.price =  product.getPrice();
        this.quantity = quantity;
    }
}
