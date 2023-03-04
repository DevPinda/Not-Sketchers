package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

    @Entity
    @Table(name = "Customer_Orders")
    public class CustomerOrdersEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Customer_ID")
        private int Customer_ID;

        @Column(name = "Order_ID")
        private int Order_ID;

        public int getCustomerId(){
            return Customer_ID;
        }

        public int getOrderId(){
            return Order_ID;
        }
}
