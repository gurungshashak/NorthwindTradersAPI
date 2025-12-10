package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoJDBCImpl implements ProductDao{
    private ArrayList<Product> products;

    private DataSource dataSource;

@Autowired
    public ProductDaoJDBCImpl(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }

    public List<Product> getAll() {
        this.products.clear();
        String query = "select p.productID, c.categoryID, p.productName, p.UnitPrice from products as p join categories as c  on (c.categoryID = p.categoryID)";

        try {
            Connection connection = dataSource.getConnection();
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet set = statement.executeQuery();
                while(set.next()) {
                    products.add(new Product(set.getInt(1), set.getInt(2), set.getString(3), set.getDouble(4)));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public Product getById(int productId) {
        String query = "SELECT ProductID, ProductName, UnitPrice, CategoryID FROM Products WHERE ProductID = ?";
        Product product = null;

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, productId);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        product = new Product(
                                rs.getInt("ProductID"),
                                rs.getInt("CategoryID"),
                                rs.getString("ProductName"),
                                rs.getDouble("UnitPrice")
                        );
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return product;
    }

}