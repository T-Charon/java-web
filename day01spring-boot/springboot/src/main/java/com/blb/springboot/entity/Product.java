package com.blb.springboot.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/6/20
 **/

public class Product {
    private String id;
    private String productName;
    private String productImage;
    private Double price;
    private String productType;
    private String productDesc;
    private LocalDateTime createTime;
    private String productBrand;

    public Product(String id, String productName, String productImage, Double price, String productType, String productDesc, LocalDateTime createTime, String productBrand) {
        this.id = id;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.productType = productType;
        this.productDesc = productDesc;
        this.createTime = createTime;
        this.productBrand = productBrand;
    }

    public Product() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public Double getPrice() {
        return price;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public String getProductBrand() {
        return productBrand;
    }
}
