package com.example.foodorderingmanagementsystem.controller;

import com.example.foodorderingmanagementsystem.model.OrderItem;
import com.example.foodorderingmanagementsystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/order-items")

public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    //1.Add new Order item and Calling the addNewOrderItem Method which is declear in service layer.
    @PostMapping
    public ResponseEntity<OrderItem> addNewOrderItem(@RequestBody OrderItem orderItem) {
        if (orderItem.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }
        return ResponseEntity.ok(orderItemService.addNewOrderItem(orderItem));
    }


    //2.Get All Order Items and calling getAllOrderItems Method..
    @GetMapping
    public List<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }


    //3.Get any order item by id using URL Path and calling the getOrderItemById method..
    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }


    //4.Update any order item by id Using URL path and edit update any field from Body--> raw.
    @PutMapping("/{id}")
    public OrderItem updateOrderItem(@PathVariable Long id,@RequestBody OrderItem orderItem){
        return orderItemService.updateOrderItem(id,orderItem);
    }


    //5.Delete any oder item by id
    @DeleteMapping("/{id}")
    public String deleteOrderItem(@PathVariable Long id){
        return orderItemService.deleteOrderItem(id);
    }


}
