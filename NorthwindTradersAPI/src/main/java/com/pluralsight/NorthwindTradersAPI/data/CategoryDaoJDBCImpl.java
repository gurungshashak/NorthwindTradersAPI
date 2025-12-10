package com.pluralsight.NorthwindTradersAPI.data;

import com.pluralsight.NorthwindTradersAPI.model.Category;
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
public class CategoryDaoJDBCImpl implements CategoryDao{
    private ArrayList<Category> categories;

    private DataSource dataSource;

    @Autowired
    public CategoryDaoJDBCImpl(DataSource dataSource) {
        this.categories = new ArrayList<>();
        this.dataSource = dataSource;
    }
    @Override
    public List<Category> getAll() {
        this.categories.clear();
        String sql = "SELECT CategoryID, CategoryName FROM Categories;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.categories.add(new Category(rows.getInt(1), rows.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.categories;
    }

    @Override
    public Category getById(int categoryId) {
        String query = "SELECT CategoryID, CategoryName FROM Categories WHERE CategoryID = ?";
        Category category = null;

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, categoryId);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        category = new Category(
                                rs.getInt("CategoryID"),
                                rs.getString("CategoryName")
                        );
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;
    }
}