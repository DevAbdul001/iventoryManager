package com.inventory.app.Repositories;

import com.inventory.app.Models.OrderItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("""
            SELECT ot
            FROM OrderItem ot
            JOIN FETCH ot.order
            WHERE ot.order.id = :orderId
            """)
    List<OrderItem> findAllWithProducts(Long orderId);

    @EntityGraph(attributePaths = "product")
    Optional<OrderItem> findById(Long id);
}
