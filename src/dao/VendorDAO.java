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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM watch.vendor");
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
}
