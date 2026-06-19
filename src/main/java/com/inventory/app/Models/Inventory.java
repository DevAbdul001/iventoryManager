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
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


    protected Inventory(){

    }

    public Inventory(Product product ,int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }
}
