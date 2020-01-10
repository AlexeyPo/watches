package dao;

import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    String showListOfCountries = "SELECT id, name FROM watch.country";
    String countryIsAvailable = "SELECT name FROM watch.country WHERE name = ?";

    public List<Country> showListOfCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(showListOfCountries);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                countries.add(new Country(id, name));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public boolean countryIsAvailable(String country) {
        try (Connection connection = ConnectorDB.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(countryIsAvailable);
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultSet.getString("name");
                statement.close();
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
