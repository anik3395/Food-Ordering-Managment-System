package com.example.foodorderingmanagementsystem.repository;

import com.example.foodorderingmanagementsystem.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
