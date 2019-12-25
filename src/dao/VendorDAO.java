package dao;

import model.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    public List<Vendor> showListOfVendors() {
        List<Vendor> vendors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from watch.vendor");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                vendors.add(new Vendor(id, title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendors;
    }
}
