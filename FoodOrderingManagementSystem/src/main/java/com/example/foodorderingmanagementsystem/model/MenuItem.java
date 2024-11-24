package com.example.foodorderingmanagementsystem.model;

import jakarta.persistence.*;

@Entity
@Table
public class MenuItem {

    //All field for my MenuItem Entity..
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private boolean available;

    //No-Argument Constructor..
    public MenuItem() {

    }

    //Parameterize Constructor for my Menuitem Entity..
    public MenuItem(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }


    //Getter for value get from class's object  and return the value..
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return available;
    }


    //Setter for newly set value when i want..
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name){
        this.name =name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }


}
