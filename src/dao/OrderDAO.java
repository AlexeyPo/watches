package dao;

import model.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public List<Order> showListOfOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection()) {
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
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void addNewOrder(int cardNumber, String model, int quantityInOrder) {
        double price = 0;
        double discount = 0;
        double amount;
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT price FROM watch.item WHERE model = ?");
            statement.setString(1, model);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                price = resultSet.getDouble("price");
            }
            statement.close();

            PreparedStatement statement1 = connection.prepareStatement("SELECT personal_discount " +
                    "FROM watch.customer WHERE card_number = ?");
            statement1.setInt(1, cardNumber);
            ResultSet resultSet1 = statement1.executeQuery();
            if (resultSet1.next()) {
                discount = resultSet1.getDouble("personal_discount");
            }
            statement1.close();

            amount = (price * quantityInOrder) - (price * quantityInOrder * (discount / 100));

            PreparedStatement statementIns = connection.prepareStatement("" +
                    "INSERT INTO watch.\"order\"(date_time, amount, customer_id, item_id, quantity_in_order) VALUES " +
                    "(CURRENT_TIMESTAMP, ?, (SELECT id FROM watch.customer WHERE card_number = ?), " +
                    "(SELECT id FROM watch.item WHERE model = ?), ?)");
            statementIns.setDouble(1, amount);
            statementIns.setInt(2, cardNumber);
            statementIns.setString(3, model);
            statementIns.setInt(4, quantityInOrder);
            statementIns.executeUpdate();
            statementIns.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
