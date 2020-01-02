package dao;

import model.Item;
import model.Trademark;
import model.WatchType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class ItemDAO {

    public List<Item> showListOfItems() {
        List<Item> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select item.*, trademark.title as trademark_title, " +
                    "watch_type.title as type_title from watch.item cross join watch.trademark cross join watch.watch_type " +
                    "where trademark_id=trademark.id and watch_type_id=watch_type.id");
            while (resultSet.next()) {
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String trademark = resultSet.getString("trademark_title");
                String watchType = resultSet.getString("type_title");
                items.add(new Item(model, price, quantity, new Trademark(trademark), new WatchType(watchType)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void addNewItem(Item item) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("insert into watch.item(model, price, quantity, " +
                    "trademark_id, watch_type_id) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, item.getModel());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getQuantity());
            statement.setObject(4, item.getTrademark());
            statement.setObject(5, item.getWatchType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void editItem(String model, int watchType, double price) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("update watch.item set watch_type_id = ?, price = ? where model = ?");
            statement.setInt(1, watchType);
            statement.setDouble(2, price);
            statement.setString(3, model);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean findItem(String model){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM watch.item WHERE model=?");
            statement.setString(1, model);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                resultSet.getInt("id");
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
