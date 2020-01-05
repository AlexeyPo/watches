package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static dao.VendorDAO.*;

public class CustomerDAO {

    public List<Customer> showListOfCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM watch.customer");
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
            statement.close();
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
            PreparedStatement statement = connection.prepareStatement("UPDATE watch.customer SET name = ?, " +
                    "total_sum = ?, card_number = ? WHERE id = ?");
            statement.setString(1, name);
            statement.setDouble(2, sum);
            statement.setDouble(3, cardNumber);
            statement.setInt(4, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM watch.customer WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean customerIsAvailable(int cardNumber) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT card_number FROM watch.customer " +
                    "WHERE card_number = ?");
            statement.setInt(1, cardNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultSet.getInt("card_number");
                statement.close();
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean findCustomerById(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT id FROM watch.customer " +
                    "WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                resultSet.getInt("id");
                statement.close();
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void checkCustomerDiscount(int cardNumber) {
        int totalSum = 0;
        int discount = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT total_sum FROM watch.customer " +
                    "WHERE card_number = ?");
            statement.setInt(1, cardNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                totalSum = resultSet.getInt("total_sum");
            }

            if (totalSum >= 5000 && totalSum < 10000) {
                discount = 2;
            } else if (totalSum >= 10000 && totalSum < 30000) {
                discount = 5;
            } else if (totalSum >= 30000) {
                discount = 10;
            }
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE watch.customer " +
                    "SET personal_discount = ? WHERE card_number = ?");
            preparedStatement.setInt(1, discount);
            preparedStatement.setInt(2, cardNumber);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomerTotalAmount() {
        double amount = 0;
        int customerId = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT amount, customer_id " +
                    "FROM watch.\"order\" ORDER BY id DESC LIMIT 1");
            while (resultSet.next()) {
                amount = resultSet.getDouble("amount");
                customerId = resultSet.getInt("customer_id");
            }
            statement.close();

            PreparedStatement statementUpd = connection.prepareStatement("UPDATE watch.customer " +
                    "SET total_sum = (SELECT total_sum + ? FROM watch.customer WHERE id = ?) WHERE id = ?");
            statementUpd.setDouble(1, amount);
            statementUpd.setInt(2, customerId);
            statementUpd.setInt(3, customerId);
            statementUpd.executeUpdate();
            statementUpd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
