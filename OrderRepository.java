package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing order records in the database.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    // Get all orders placed by a specific user
    List<OrderEntity> findByUserId(Long userId);

    // Get orders filtered by status (Pending, Shipped, Delivered)
    List<OrderEntity> findByStatus(String status);
}
