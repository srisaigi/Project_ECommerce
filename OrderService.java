package com.ecommerce.backend.service;

import com.ecommerce.backend.model.OrderEntity;
import com.ecommerce.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Handles order management — placing, tracking, and retrieving orders.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Get all orders
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get orders by user ID
    public List<OrderEntity> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // Get specific order
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Place a new order
    public OrderEntity placeOrder(OrderEntity order) {
        order.setStatus("PENDING");
        order.setCreatedAt(java.time.LocalDateTime.now());
        return orderRepository.save(order);
    }

    // Update order status
    public OrderEntity updateOrderStatus(Long id, String status) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(id);
        if (orderOpt.isPresent()) {
            OrderEntity order = orderOpt.get();
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    // Delete an order
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
