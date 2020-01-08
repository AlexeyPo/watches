package manage;

import dao.CustomerDAO;
import model.Customer;

import java.util.Scanner;

public class CustomerManager {

    CustomerDAO customerDAO = new CustomerDAO();
    Scanner scanner = new Scanner(System.in);

    public void showCustomers() {
        System.out.println("-------- Customers --------------");
        System.out.printf("%2s || %11s || %9s || %17s || %s\n", "id", "Second Name", "total sum", "personal discount", "card ID");

        for (Customer customer : customerDAO.showListOfCustomers()) {
            System.out.printf("%2d || %11s || %9.2f || %15.2f %% || %d\n", customer.getId(), customer.getName(),
                    customer.getTotalSum(), customer.getPersonalDiscount(), customer.getCardNumber());
        }
        System.out.println("---------------------------------");
    }

    public void addNewCustomer() {
        System.out.println("Please, enter new Customer's card number: ");
        int cardNumber = scanner.nextInt();

        if (!customerDAO.customerIsAvailable(cardNumber)) {
            System.out.println("Please, enter new Customer's Second Name: ");
            String name = scanner.nextLine();

            System.out.println("Please, enter new Customer's sum: ");
            double sum = scanner.nextDouble();

            customerDAO.addNewCustomer(new Customer.Builder()
                    .withName(name)
                    .withTotalSum(sum)
                    .withCardNumber(cardNumber)
                    .build());
            showCustomers();

            System.out.println("The customer was successfully added");

        } else {
            showCustomers();
            System.out.println("Such customer already exist!!!");
        }
    }

    public void editCustomer() {
        System.out.println("Please, enter Customer's ID for changing: ");
        int id = scanner.nextInt();

        if (customerDAO.findCustomerById(id)) {

            System.out.println("Please, enter Customer's new Second Name: ");
            String name = scanner.next();

            System.out.println("Please, enter Customer's new sum: ");
            double sum = scanner.nextDouble();

            System.out.println("Please, enter Customer's new card number: ");
            double cardNumber = scanner.nextDouble();

            customerDAO.editCustomer(name, sum, cardNumber, id);
            showCustomers();
            System.out.println("The customer was successfully updated");
        } else {
            showCustomers();
            System.out.println("The customer with such ID was not found!!! Please, check and try again!");
        }
    }

    public void deleteCustomer() {
        System.out.println("Please, enter Customer's ID for deleting: ");
        int id = scanner.nextInt();

        if (customerDAO.findCustomerById(id)) {
            customerDAO.deleteCustomer(id);
            showCustomers();
            System.out.println("The customer was successfully deleted");
        } else {
            showCustomers();
            System.out.println("The customer with such ID was not found!!! Please, check and try again!");
        }
    }

    public void checkCustomerDiscount(int cardNumber) {
        customerDAO.checkCustomerDiscount(cardNumber);
    }

    public void updateCustomerTotalAmount() {
        customerDAO.updateCustomerTotalAmount();
    }
}
