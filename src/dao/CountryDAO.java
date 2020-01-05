package dao;

import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class CountryDAO {

    public List<Country> showListOfCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM watch.country");
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
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM watch.country " +
                    "WHERE name = ?");
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
