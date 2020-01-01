package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class CustomerDAO {

    public List<Customer> findListOfCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from watch.customer");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double totalSum = resultSet.getDouble("total_sum");
                int cardNumber = resultSet.getInt("card_number");
                double personalDiscount = resultSet.getDouble("personal_discount");
                customers.add(new Customer.Builder()
                        .withId(id)
                        .withName(name)
                        .withTotalSum(totalSum)
                        .withCardNumber(cardNumber)
                        .withPersonalDiscount(personalDiscount)
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void addNewCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("insert into watch.customer(name, total_sum, " +
                    "card_number, personal_discount) VALUES (?, ?, ?, ?)");
            statement.setString(1, customer.getName());
            statement.setDouble(2, customer.getTotalSum());
            statement.setInt(3, customer.getCardNumber());
            statement.setDouble(4, customer.getPersonalDiscount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(String name, double sum, double cardNumber, int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("update watch.customer set name = ?, " +
                    "total_sum = ?, card_number = ? where id = ?");
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
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("delete from watch.customer where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
