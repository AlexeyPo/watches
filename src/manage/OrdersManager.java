package manage;

import dao.CustomerDAO;
import dao.ItemDAO;
import dao.OrderDAO;
import model.Order;

import java.util.Scanner;

public class OrdersManager {

    OrderDAO orderDAO = new OrderDAO();
    CustomerDAO customerDAO = new CustomerDAO();
    ItemDAO itemDAO = new ItemDAO();
    CustomerManager customerManager = new CustomerManager();
    Scanner scanner = new Scanner(System.in);

    public void showOrders() {
        System.out.println("---------------------------------------- Orders -----------------------------------------");
        System.out.printf("%19s || %15s || %7s || %10s || %15s || %10s || %9s || %3s || %8s || %9s\n",
                "Date and time", "Customer's Name", "Card ID", "Trademark", "Model", "Watch Type", "Price", "Qty",
                "Discount", "Amount");

        for (Order order : orderDAO.showListOfOrders()) {
            System.out.printf("%td.%tm.%tY %tT || %15s || %7d || %10s || %15s || %10s || %9.2f || %3d || %8.1f || %9.2f\n",
                    order.getDateTime(), order.getDateTime(), order.getDateTime(), order.getDateTime(),
                    order.getCustomer().getName(), order.getCustomer().getCardNumber(), order.getTrademark(),
                    order.getItem().getModel(), order.getWatchType(), order.getItem().getPrice(),
                    order.getQuantityInOrder(), order.getCustomer().getPersonalDiscount(), order.getAmount());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void addNewOrder() {
        System.out.println("Please, enter new Customer's card number: ");
        int cardNumber = scanner.nextInt();

        if (customerDAO.customerIsAvailable(cardNumber)) {
            customerManager.checkCustomerDiscount(cardNumber);

            System.out.println("Please, enter the chosen model for adding to order: ");
            String model = scanner.next();

            if (itemDAO.itemIsAvailable(model)) {
                System.out.println("Please, enter quantity for adding to order: ");
                int quantityInOrder = scanner.nextInt();

                orderDAO.addNewOrder(cardNumber, model, quantityInOrder);
                customerManager.updateCustomerTotalAmount();
                showOrders();
            } else {
                System.out.println("Such model was not fount");
            }
        } else {
            showOrders();
            System.out.println("The customer with such card number was not found!!! Please, check and try again!");
        }
    }
}
