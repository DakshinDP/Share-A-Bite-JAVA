package main.java.model;

import main.java.model.FoodItem;
import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/shareabite";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void addFoodItem(FoodItem item) {
        String sql = "INSERT INTO food_items VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getId());
            stmt.setString(2, item.getFoodName());
            stmt.setString(3, item.getExpiryDate());
            stmt.setString(4, item.getFoodType());
            stmt.setString(5, item.getImagePath());
            stmt.setDouble(6, item.getLatitude());
            stmt.setDouble(7, item.getLongitude());
            stmt.setBoolean(8, false);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAvailableFoodItems() {
        String sql = "SELECT * FROM food_items WHERE is_claimed = FALSE";
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void claimFoodItem(String id) {
        String sql = "UPDATE food_items SET is_claimed = TRUE WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}