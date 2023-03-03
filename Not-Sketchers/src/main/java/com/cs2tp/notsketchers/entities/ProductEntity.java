package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ID")
    private int productId;

    @Column(name = "Product_Name")
    private String productName;

    @Column(name = "Product_Category")
    private String productCategory;

    @Column(name = "Product_Price")
    private double productPrice;

    @Column(name = "Product_StockCount")
    private int productStockCount;

    @Column(name = "Product_ImageFilePath")
    private String productImageFilePath;

    public int getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public double getProductPrice(){
        return productPrice;
    }

    public int getStockCount(){
        return productStockCount;
    }

    public String getProductImageFilePath(){
        return productImageFilePath;
    }
}