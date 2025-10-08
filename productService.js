package com.ecommerce.backend.service;

import com.ecommerce.backend.model.ProductEntity;
import com.ecommerce.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Handles all product-related business logic.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Search products by keyword
    public List<ProductEntity> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
    }

    // Add or update a product
    public ProductEntity saveProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
