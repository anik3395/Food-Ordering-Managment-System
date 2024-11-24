package com.example.foodorderingmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    //All field for my Order_item Entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore // Prevents infinite loop
    private Order order;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;


    private int quantity;
    private double price;

    //No-Argument Constructor..
    public OrderItem(){

    }
    //Parameterize Constructor for my Order_item Entity..
    public OrderItem(Order order, MenuItem menuItem, int quantity, double price){
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.price = price;
    }

    //Getter for value get from class's object  and return the value..
    public long getId() {
        return id;
    }
    public Order getOrder() {
        return order;
    }
    public MenuItem getMenuItem() {
        return menuItem;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }

    //Setter for newly set value when i want..
    public void setId(long id) {
        this.id = id;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }


}
