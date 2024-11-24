package com.example.foodorderingmanagementsystem.controller;

import com.example.foodorderingmanagementsystem.model.Order;
import com.example.foodorderingmanagementsystem.model.OrderItem;
import com.example.foodorderingmanagementsystem.model.OrderStatus;
import com.example.foodorderingmanagementsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //1.Make or Place a New Order by makeNewOrder Calling and all JSON file client's input
    //put into the Order object which is called order..
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestParam Long customerId, @RequestBody List<OrderItem> items) {
        Order order = orderService.placeOrder(customerId, items);
        return ResponseEntity.ok(order);
    }


    // Update order status
    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus newStatus) {
        Order updatedOrder = orderService.updateOrderStatus(orderId, newStatus);
        return ResponseEntity.ok(updatedOrder);
    }


    // Fetch order details
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {
        return new ResponseEntity<>(orderService.getOrderDetails(orderId), HttpStatus.OK);
    }









}
