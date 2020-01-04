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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM watch.country");
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
}
