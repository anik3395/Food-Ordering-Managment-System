package com.example.foodorderingmanagementsystem.service;

import com.example.foodorderingmanagementsystem.model.OrderItem;
import com.example.foodorderingmanagementsystem.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    //1.Here the calling method and save all data in DB by the object(orderItem)
    public OrderItem addNewOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }


    //2.Find the all order Item from the DB and calling the method.
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }


    //3.Get an order item by id and find out from DB. ***Remaining Exception Handling***
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).get();
    }


    //4.Update an order item by Set new value and again store or save in the DB..
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        OrderItem myOldOrderItem = orderItemRepository.findById(id).get();
        myOldOrderItem.setQuantity(orderItem.getQuantity());
        myOldOrderItem.setPrice(orderItem.getPrice());
        myOldOrderItem.setMenuItem(orderItem.getMenuItem());
        myOldOrderItem.setOrder(orderItem.getOrder());
        return orderItemRepository.save(myOldOrderItem);
    }


    //5.Delete an order item by providing id in URL Path (@PathVariable) and **Exception not working**
    public String deleteOrderItem(Long id) {

        if(!orderItemRepository.existsById(id)) {
            throw new RuntimeException(" OPPS! Order item" + id + " not found");
        }
        orderItemRepository.deleteById(id);
        return "Yaa, Order item" + id + "deleted";

    }



}
