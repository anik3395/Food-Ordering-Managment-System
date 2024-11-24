package com.example.foodorderingmanagementsystem.controller;

import com.example.foodorderingmanagementsystem.model.MenuItem;
import com.example.foodorderingmanagementsystem.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu/menu-items")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    //1.Add Menu Item Controller. Here Call the addNewMenuItem Method
    @PostMapping
    public MenuItem addNewMenuItem(@RequestBody MenuItem menuItem){
        return menuItemService.addNewMenuItem(menuItem);
    }

    //2.Get Menu Item and call the getAllMenuItems method..
    @GetMapping
    public List<MenuItem> getAllMenuItems(){
        return menuItemService.getAllMenuItems();
    }

    //3.Update menu item availability and call updateAvailability Method..
    @PutMapping("/{id}/availability")
    public ResponseEntity<MenuItem> updateAvailability(@PathVariable Long id, @RequestParam boolean available){
        return ResponseEntity.ok(menuItemService.updateAvailability(id, available));
    }

    //4.Update menu item price and call updatePrice Method.. //Another Process
    @PutMapping("/{id}/price")
    public MenuItem updatePrice(@PathVariable Long id,@RequestParam double price){
        return menuItemService.updatePrice(id,price);
    }


}
