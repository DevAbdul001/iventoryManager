package com.inventory.app.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table( name = "orders")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;
    private Long userId;
    private BigDecimal total;
    private String status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    protected Order(){

    }

    public Order( User user, BigDecimal total, String status){
       this.userId = user.getId();
        this.total = total;
        this.status = "Pending";
    }


}
