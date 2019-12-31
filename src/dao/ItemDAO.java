package dao;

import model.Item;
import model.Trademark;
import model.WatchType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public List<Item> findListOfItems(){
        List<Item> items = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select item.*, trademark.title, watch_type.title from watch.item cross join watch.trademark cross join watch.watch_type where trademark_id=trademark.id and watch_type_id=watch_type.id");
            while (resultSet.next()){
                String model = resultSet.getString("model");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String trademark = resultSet.getString("title");
                String watchType = resultSet.getString("watch_type.title");
                items.add(new Item(model, price, quantity, trademark, watchType));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}
