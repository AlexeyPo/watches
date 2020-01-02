package ui;

import manage.CustomerManager;

import static ui.MainMenu.*;

public class CustomerMenu implements AppMenu {

    private CustomerManager customerManager = new CustomerManager();

    @Override
    public void printMenu() {
        System.out.println("========= Customer Menu =========");
        System.out.println("1. Add new Customer");
        System.out.println("2. Edit Customer");
        System.out.println("3. Delete Customer");
        System.out.println("0. Back to main menu");
        System.out.println("=================================");
    }

    @Override
    public void returnPointMenu(int selection) {
        switch (selection) {
            case ADD_NEW:
                customerManager.addNewCustomer();
                break;
            case EDIT:
                customerManager.editCustomer();
                break;
            case DELETE:
                customerManager.deleteCustomer();
                break;
        }
    }
}
