package com.example.foodorderingmanagementsystem.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    //All field for my Order Entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date orderDate;

    //@Column(nullable = false)
    private long customerId;

    @Enumerated(EnumType.STRING)
    //@Column(nullable = false)
    private OrderStatus orderStatus;

    //@Column(nullable = false)
    private double totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    //No-Argument Constructor..
    public Order() {

    }

    //Parameterize Constructor for my Menuitem Entity..
    public Order(Date orderDate, long customerId, OrderStatus orderStatus, double totalAmount, List<OrderItem> orderItems) {
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
    }

    //Getter for value get from class's object  and return the value..
    public long getId() {
        return id;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public long getCustomerId() {
        return customerId;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


    //Setter for newly set value when i want..
    public void setId(long id) {
        this.id =id;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }





}
