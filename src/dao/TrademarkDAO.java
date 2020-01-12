package dao;

import model.Trademark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrademarkDAO {
    String showTrademarksByWatchType = "SELECT DISTINCT title FROM watch.trademark JOIN watch.item " +
            "ON trademark.id = item.trademark_id AND watch_type_id = ?";

    String showTrademarkByCountry = "SELECT trademark.title FROM watch.trademark JOIN watch.vendor " +
            "ON trademark.vendor_id = vendor.id JOIN watch.country ON vendor.country_id = country.id WHERE country.name= ?";

    public List<Trademark> showTrademarksByWatchType(int id) {
        List<Trademark> trademarks = new ArrayList<>();

        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(showTrademarksByWatchType);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                trademarks.add(new Trademark(title));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trademarks;
    }

    public List<Trademark> showTrademarkByCountry(String country) {
        List<Trademark> trademarks = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(showTrademarkByCountry);
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                trademarks.add(new Trademark(title));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trademarks;
    }
}
