package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing product entities in the database.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // Find all products by category
    List<ProductEntity> findByCategory(String category);

    // Search for products containing keyword in name or description
    List<ProductEntity> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
}
