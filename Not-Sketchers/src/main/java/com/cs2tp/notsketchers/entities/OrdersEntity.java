package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID")
    private int Order_ID;

    @Column(name = "Customer_ID")
    private int Customer_ID;

    @Column(name = "Product_ID")
    private int Product_ID;

    @Column(name = "Product_Name")
    private String Product_Name;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Order_Date")
    private Timestamp Order_Date;

    public int getOrderId(){
        return Order_ID;
    }

    public int getCustomerId(){
        return Customer_ID;
    }

    public int getProductId(){
        return Product_ID;
    }

    public String getProductName(){
        return Product_Name;
    }

    public int getQuantity(){
        return Quantity;
    }

    public Timestamp getTimeStamp(){
        return Order_Date;
    }
}