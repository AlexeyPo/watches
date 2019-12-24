package dao;

import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public List<Country> findListOfCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from watch.country");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                countries.add(new Country(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
