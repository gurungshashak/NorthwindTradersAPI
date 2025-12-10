package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getAll();
    public Category getById(int categoryId);
}