package manage;

import dao.CustomerDAO;
import model.Customer;

import java.util.Scanner;

public class CustomerManager {

    CustomerDAO customerDAO = new CustomerDAO();
    Scanner scanner = new Scanner(System.in);

    public void showCustomers() {
        System.out.println("-------- Customers --------------");
        for (Customer customer : customerDAO.findListOfCustomers()) {
            System.out.printf("id: %d || Second Name: %8s || total sum: %5.2f || card ID: %d\n", customer.getId(),
                    customer.getName(), customer.getTotalSum(), customer.getCardNumber());
        }
        System.out.println("---------------------------------");
    }

    public void addNewCustomer() {

        System.out.println("Please, enter new Customer's Second Name: ");
        String name = scanner.next();
        System.out.println("Please, enter new Customer's sum: ");
        double sum = scanner.nextDouble();
        System.out.println("Please, enter new Customer's card number: ");
        int cardNumber = scanner.nextInt();

        customerDAO.addNewCustomer(new Customer(name, sum, cardNumber));
        showCustomers();
    }

    public void editCustomer() {
        System.out.println("Please, enter Customer's ID for changing: ");
        int id = scanner.nextInt();
        System.out.println("Please, enter Customer's new Second Name: ");
        String name = scanner.next();
        System.out.println("Please, enter Customer's new sum: ");
        double sum = scanner.nextDouble();
        System.out.println("Please, enter Customer's new card number: ");
        double cardNumber = scanner.nextDouble();

        customerDAO.editCustomer(name, sum, cardNumber, id);
        showCustomers();
    }

    public void deleteCustomer() {
        System.out.println("Please, enter Customer's ID for deleting: ");
        int id = scanner.nextInt();
        customerDAO.deleteCustomer(id);
        showCustomers();
        scanner.close();
    }
}
