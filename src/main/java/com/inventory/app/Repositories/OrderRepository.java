package com.inventory.app.Repositories;

import com.inventory.app.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository <Order, Long> {

}
