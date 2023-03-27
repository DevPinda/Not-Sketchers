package com.cs2tp.notsketchers.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "product")
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
    private BigDecimal productPrice;

    @Column(name = "Product_StockCount")
    private int productStockCount;

    @Column(name = "Product_ImageFilePath")
    private String productImageFilePath;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Size")
    private String shoeSize;

    public int getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public String getProductCategory(){
        return productCategory;
    }

    public BigDecimal getProductPrice(){
        return productPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public int getStockCount(){
        return productStockCount;
    }

    public String getProductImageFilePath(){
        return productImageFilePath;
    }

    public String getGender() {
        return gender;
    }

    public String getShoeSize() {
        return shoeSize;
    }

    public StockSupply getSupply() {
        return StockSupply.getBasedOnStock(this.getStockCount());
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductStockCount(int productStockCount) {
        this.productStockCount = productStockCount;
    }

    public void setProductImageFilePath(String productImageFilePath) {
        this.productImageFilePath = productImageFilePath;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setShoeSize(String shoeSize) {
        this.shoeSize = shoeSize;
    }
}