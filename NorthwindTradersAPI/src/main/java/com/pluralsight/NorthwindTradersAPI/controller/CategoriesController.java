package com.pluralsight.NorthwindTradersAPI.controller;


import com.pluralsight.NorthwindTradersAPI.data.CategoryDao;
import com.pluralsight.NorthwindTradersAPI.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//http://localhost:8080/categories
@RestController
public class CategoriesController {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoriesController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public List<Category> getAllProducts() {
        return categoryDao.getAll();
    }

    @RequestMapping(path="/categories/{id}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int id) {
        return categoryDao.getById(id);
    }
}
