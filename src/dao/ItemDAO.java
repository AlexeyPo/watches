package dao;

import model.Item;
import model.Trademark;
import model.WatchType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    String showListOfItems = "SELECT item.*, trademark.title AS trademark_title, watch_type.title AS type_title " +
            "FROM watch.item CROSS JOIN watch.trademark CROSS JOIN watch.watch_type " +
            "WHERE trademark_id=trademark.id AND watch_type_id=watch_type.id";

    String addNewItem = "INSERT INTO watch.item(model, price, quantity, trademark_id, watch_type_id) VALUES (?, ?, ?, ?, ?)";
    String editItem = "UPDATE watch.item SET watch_type_id = ?, price = ? WHERE model = ?";
    String itemIsAvailable = "SELECT id FROM watch.item WHERE model=?";

    String showWatchByPrice = "SELECT item.*, trademark.title AS trademark_title, watch_type.title AS type_title " +
            "FROM watch.item CROSS JOIN watch.trademark CROSS JOIN watch.watch_type " +
            "WHERE trademark_id=trademark.id AND watch_type_id=watch_type.id AND watch_type.id = 2 AND price <= ?";


    public List<Item> showListOfItems() {
        List<Item> items = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(showListOfItems);
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String trademark = resultSet.getString("trademark_title");
                String watchType = resultSet.getString("type_title");
                items.add(new Item(model, price, quantity, new Trademark(trademark), new WatchType(watchType)));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void addNewItem(Item item) {
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(addNewItem);
            statement.setString(1, item.getModel());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getQuantity());
            statement.setObject(4, item.getTrademark());
            statement.setObject(5, item.getWatchType());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editItem(String model, int watchType, double price) {
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(editItem);
            statement.setInt(1, watchType);
            statement.setDouble(2, price);
            statement.setString(3, model);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean itemIsAvailable(String model) {
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(itemIsAvailable);
            statement.setString(1, model);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultSet.getInt("id");
                statement.close();
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Item> showWatchByPrice(double price) {
        List<Item> items = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(showWatchByPrice);
            statement.setDouble(1, price);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String trademark = resultSet.getString("trademark_title");
                String watchType = resultSet.getString("type_title");
                items.add(new Item(model, price, quantity, new Trademark(trademark), new WatchType(watchType)));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
