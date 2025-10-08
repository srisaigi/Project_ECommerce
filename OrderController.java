package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.OrderRequest;
import com.ecommerce.backend.dto.OrderResponse;
import com.ecommerce.backend.model.OrderEntity;
import com.ecommerce.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing customer orders.
 * Handles CRUD operations related to orders.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Create a new order
     */
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse createdOrder = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(createdOrder);
    }

    /**
     * Get all orders
     */
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    /**
     * Get order by ID
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long orderId) {
        OrderEntity order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    /**
     * Get all orders by a specific user ID
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderEntity>> getOrdersByUser(@PathVariable Long userId) {
        List<OrderEntity> userOrders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(userOrders);
    }

    /**
     * Update order status (e.g., Pending → Shipped → Delivered)
     */
    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderEntity> updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        OrderEntity updatedOrder = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }

    /**
     * Delete an order
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
