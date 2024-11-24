package com.example.foodorderingmanagementsystem.service;

import com.example.foodorderingmanagementsystem.exception.InvalidOrderStateException;
import com.example.foodorderingmanagementsystem.exception.ResourceNotFoundException;
import com.example.foodorderingmanagementsystem.model.MenuItem;
import com.example.foodorderingmanagementsystem.model.Order;
import com.example.foodorderingmanagementsystem.model.OrderItem;
import com.example.foodorderingmanagementsystem.model.OrderStatus;
import com.example.foodorderingmanagementsystem.repository.MenuItemRepository;
import com.example.foodorderingmanagementsystem.repository.OrderItemRepository;
import com.example.foodorderingmanagementsystem.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    // Place a new order
    public Order placeOrder(Long customerId, List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must be at least one item.");
        }

        double totalAmount = 0.0;

        // Validate each item
        for (OrderItem item : items) {
            MenuItem menuItem = menuItemRepository.findById(item.getMenuItem().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("MenuItem with ID " + item.getMenuItem().getId() + " not found."));

            if (!menuItem.isAvailable()) {
                throw new ResourceNotFoundException("MenuItem " + menuItem.getName() + " is not available.");
            }

            item.setMenuItem(menuItem);
            item.setPrice(menuItem.getPrice());
            totalAmount += item.getQuantity() * menuItem.getPrice();
        }


        // Create the order
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderDate(new Date());
        order.setOrderStatus(OrderStatus.PLACED);
        order.setTotalAmount(totalAmount);
        order.setOrderItems(items);

        // Save order and items
        Order savedOrder = orderRepository.save(order);
        for (OrderItem item : items) {
            item.setOrder(savedOrder);
            orderItemRepository.save(item);
        }

        return savedOrder;
    }

    // Update the status of an order
    public Order updateOrderStatus(Long orderId, OrderStatus newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with ID " + orderId + " not found."));

        // Validate status transitions
        if ((order.getOrderStatus() == OrderStatus.PLACED && newStatus == OrderStatus.DELIVERED) ||
                (order.getOrderStatus() == OrderStatus.DELIVERED)) {
            throw new InvalidOrderStateException("Invalid status transition.");
        }

        order.setOrderStatus(newStatus);
        return orderRepository.save(order);
    }


    // Fetch order details by ID
    public Order getOrderDetails(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order with ID " + orderId + " not found."));
    }









}
