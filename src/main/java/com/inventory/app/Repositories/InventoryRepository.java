package com.inventory.app.Repositories;

import com.inventory.app.Models.Inventory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("""
        SELECT i
        FROM Inventory i
        JOIN FETCH i.product
    """)
    List<Inventory> findAllWithProduct();

    @EntityGraph(attributePaths = "product")
    Optional<Inventory> findById(Long id);
}