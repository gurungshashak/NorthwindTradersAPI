package com.pluralsight.NorthwindTradersAPI.model;

public class Product {
    private int productId, categoryId;
    private String productName;
    private double unitPrice;

    public Product(int productId, int categoryId, String productName, double unitPrice) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}