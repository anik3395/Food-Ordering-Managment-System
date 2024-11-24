package com.example.foodorderingmanagementsystem.repository;

import com.example.foodorderingmanagementsystem.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository< MenuItem, Long > {

}
