package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public List<Customer> findListOfCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from watch.customer");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double sum = resultSet.getDouble("sum");
                int cardNumber = resultSet.getInt("cardNumber");
                customers.add(new Customer(id, name, sum, cardNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void addNewCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            PreparedStatement statement = connection.prepareStatement("insert into watch.customer(name, sum, cardNumber) VALUES (?, ?, ?)");
            statement.setString(1, customer.getName());
            statement.setDouble(2, customer.getSum());
            statement.setInt(3, customer.getCardNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(String name, double sum, double cardNumber, int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            PreparedStatement statement = connection.prepareStatement("update watch.customer set name = ?, sum = ?, cardnumber = ? where id = ?");
            statement.setString(1, name);
            statement.setDouble(2, sum);
            statement.setDouble(3, cardNumber);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/watch", "postgres", "postgres")) {
            PreparedStatement statement = connection.prepareStatement("delete from watch.customer where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
