package dao;

import model.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    String showListOfVendors = "SELECT id, title FROM watch.vendor";
    String showVendorByTotalAmount = "SELECT SUM(\"order\".amount) AS sum, watch.vendor.title FROM watch.\"order\" " +
            "JOIN watch.item ON \"order\".item_id = item.id JOIN watch.trademark ON item.trademark_id = trademark.id " +
            "JOIN watch.vendor ON trademark.vendor_id = vendor.id WHERE amount <= ? GROUP BY vendor.title";

    public List<Vendor> showListOfVendors() {
        List<Vendor> vendors = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(showListOfVendors);
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
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(showVendorByTotalAmount);
            statement.setDouble(1, amount);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                vendors.add(new Vendor(title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendors;
    }
}
