package dao;

import model.Trademark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class TrademarkDAO {

    public List<Trademark> showTrademarksByWatchType(int id) {
        List<Trademark> trademarks = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT title FROM watch.trademark " +
                    " JOIN watch.item ON trademark.id = item.trademark_id AND watch_type_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String title = resultSet.getString("title");
                trademarks.add(new Trademark(title));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trademarks;
    }

}
