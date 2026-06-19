package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String description;
    public String img_url;
    public BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<Inventory> inventories;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    protected  Product(){

    }

    public Product( String name, String description, String img_url, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.img_url = img_url;
        this.price = price;
    }



}
