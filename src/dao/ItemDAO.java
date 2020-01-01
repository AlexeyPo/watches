package dao;

import model.Item;
import model.Trademark;
import model.WatchType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class ItemDAO {

    public List<Item> findListOfItems(){
        List<Item> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select item.*, trademark.title as trademark_title, " +
                    "watch_type.title as type_title from watch.item cross join watch.trademark cross join watch.watch_type " +
                    "where trademark_id=trademark.id and watch_type_id=watch_type.id");
            while (resultSet.next()){
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
}
