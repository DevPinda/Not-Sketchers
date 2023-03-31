package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID")
    private int Order_ID;

    @Column(name = "Customer_ID")
    private int customerId;

    @Column(name = "Product_Name")
    private String Product_Name;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Order_Date")
    private Timestamp Order_Date;

    @Column(name = "Order_Status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int order_ID) {
        Order_ID = order_ID;
    }

    public int getCustomer_ID() {
        return customerId;
    }

    public void setCustomer_ID(int customer_ID) {
        customerId = customer_ID;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String product_Name) {
        Product_Name = product_Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Timestamp getOrder_Date() {
        return Order_Date;
    }

    public void setOrder_Date(Timestamp order_Date) {
        Order_Date = order_Date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}