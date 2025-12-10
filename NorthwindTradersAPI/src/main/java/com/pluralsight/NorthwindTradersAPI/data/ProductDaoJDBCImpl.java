package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoJDBCImpl implements ProductDao{
    private ArrayList<Product> products;

    private DataSource dataSource;

    public ProductDaoJDBCImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProductDaoJDBCImpl() {
        this.products = new ArrayList<>();

        products.add(new Product(1, 10, "Laptop", 899.99));
        products.add(new Product(2, 20, "Wireless Mouse", 19.99));
        products.add(new Product(3, 20, "Mechanical Keyboard", 59.99));
        products.add(new Product(4, 30, "LED Monitor", 149.49));
        products.add(new Product(5, 40, "USB-C Charger", 24.99));
    }

    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public Product getById(int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                return p;
            }
        }
        return null;
    }
}