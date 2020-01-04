package dao;

import model.*;

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
            ResultSet resultSet = statement.executeQuery("SELECT \"order\".date_time, \"order\".amount, " +
                    "\"order\".quantity_in_order, customer.name, customer.card_number, customer.personal_discount, " +
                    "item.model, item.price, trademark.title AS trademark, watch_type.title AS watch_type " +
                    "FROM watch.\"order\" " +
                    "JOIN watch.customer ON \"order\".customer_id = customer.id " +
                    "JOIN watch.item ON \"order\".item_id = item.id " +
                    "JOIN watch.trademark ON item.trademark_id = trademark.id " +
                    "JOIN watch.watch_type ON item.watch_type_id = watch_type.id " +
                    "ORDER BY customer.name");
            while (resultSet.next()) {
                LocalDateTime dateTime = resultSet.getTimestamp("date_time").toLocalDateTime();
                double amount = resultSet.getDouble("amount");
                int quantityInOrder = resultSet.getInt("quantity_in_order");
                String name = resultSet.getString("name");
                int cardNumber = resultSet.getInt("card_number");
                int discount = resultSet.getInt("personal_discount");
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                String trademark = resultSet.getString("trademark");
                String watchType = resultSet.getString("watch_type");
                orders.add(new Order(dateTime, amount, quantityInOrder,
                        new Customer.Builder().withName(name).withCardNumber(cardNumber).withPersonalDiscount(discount).build(),
                        new Item(model, price),
                        new Trademark(trademark),
                        new WatchType(watchType)));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
