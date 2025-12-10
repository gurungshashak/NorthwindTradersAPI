package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDaoJDBCImpl implements CategoryDao{
    private ArrayList<Category> categories;

    public CategoryDaoJDBCImpl() {
        this.categories = new ArrayList<>();

        categories.add(new Category(10, "Electronics"));
        categories.add(new Category(20, "Accessories"));
        categories.add(new Category(30, "Displays"));
        categories.add(new Category(40, "Chargers"));
        categories.add(new Category(50, "Networking"));

    }
    @Override
    public List<Category> getAll() {
        return this.categories;
    }

    @Override
    public Category getById(int categoryId) {
         for (Category c : categories) {
            if (c.getCategoryId() == categoryId) {
                return c;
            }
        }
        return null;
    }
}