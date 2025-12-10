package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getAll();
    public Product getById(int productId);
}