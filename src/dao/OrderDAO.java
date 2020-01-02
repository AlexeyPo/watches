package dao;

import model.Order;

import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class OrderDAO {

    public List<Order> showListOfOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id from watch.order");
            while (resultSet.next()) {
                LocalDateTime dateTime = resultSet.getObject("date_time", LocalDateTime.class);
                double totalAmount = resultSet.getDouble("total_amount");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
