package dao;

import model.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    static final String URL = "jdbc:postgresql://localhost:5432/watch";
    static final String USER = "postgres";
    static final String PASSWORD = "postgres";

    public List<Vendor> showListOfVendors() {
        List<Vendor> vendors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, title FROM watch.vendor");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                vendors.add(new Vendor(id, title));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendors;
    }

    public List<Vendor> showVendorByTotalAmount(double amount) {
        List<Vendor> vendors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT SUM(\"order\".amount) AS sum, watch.vendor.title " +
                    "FROM watch.\"order\" JOIN watch.item ON \"order\".item_id = item.id " +
                    "JOIN watch.trademark ON item.trademark_id = trademark.id " +
                    "JOIN watch.vendor ON trademark.vendor_id = vendor.id WHERE amount <= ? GROUP BY vendor.title");
            statement.setDouble(1, amount);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                vendors.add(new Vendor(title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendors;
    }
}
