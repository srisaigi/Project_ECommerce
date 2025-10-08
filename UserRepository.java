package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing user accounts in the database.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Find user by email (used in authentication)
    Optional<UserEntity> findByEmail(String email);

    // Check if a user with given email already exists
    boolean existsByEmail(String email);
}
