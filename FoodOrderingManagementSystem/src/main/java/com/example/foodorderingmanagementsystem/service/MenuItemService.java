package com.example.foodorderingmanagementsystem.service;

import com.example.foodorderingmanagementsystem.exception.ResourceNotFoundException;
import com.example.foodorderingmanagementsystem.model.MenuItem;
import com.example.foodorderingmanagementsystem.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemService {

    @Autowired //Add dependency injection of MenuItemRepository
    private MenuItemRepository menuItemRepository;


    //1.Add New Menu Item Method: And
    // Store the all menuItem's data into the DB.
    public MenuItem addNewMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }


    //2.Here the getAllMenuItems method and view all Menu items in json format..
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }


    //3.Find by id and set new value and update and save again DB updating Available.
    public MenuItem updateAvailability(Long id, boolean available) {
        
        // Find the MenuItem by ID
        //Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(id);
        // Check if the MenuItem exists
//        if (!optionalMenuItem.isPresent()) {
//            throw new RuntimeException("MenuItem with ID " + id + " not found.");
//        }

        // Retrieve the MenuItem object
        //MenuItem menuItem = optionalMenuItem.get();
        // Update the availability
        //menuItem.setAvailable(available);
        // Save the updated MenuItem back to the database
        //return menuItemRepository.save(menuItem);


        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("MenuItem with ID " + id + " not found."));
        menuItem.setAvailable(available);
        return menuItemRepository.save(menuItem);
    }


    //4.Find by id and set new value and update and save again DB by updating Price.
    public MenuItem updatePrice(Long id, double price) {

        Optional<MenuItem> optionalMenuItem = menuItemRepository.findById(id);
        MenuItem menuItem = optionalMenuItem.get();
        menuItem.setPrice(price);
        return menuItemRepository.save(menuItem);

    }
}
