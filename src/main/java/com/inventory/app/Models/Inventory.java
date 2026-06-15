package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table( name =  "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


    protected Inventory(){

    }

    public Inventory(Product product ,int quantity)
    {
        this.productId = product.getId();
        this.quantity = quantity;
    }
}
