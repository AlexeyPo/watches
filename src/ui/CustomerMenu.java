package ui;

import manage.CustomerManager;

public class CustomerMenu implements AppMenu {

    public static final int ADD_NEW_CUSTOMER = 1;
    public static final int EDIT_CUSTOMER = 2;
    public static final int DELETE_CUSTOMER = 3;

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
            case ADD_NEW_CUSTOMER:
                customerManager.addNewCustomer();
                break;
            case EDIT_CUSTOMER:
                customerManager.editCustomer();
                break;
            case DELETE_CUSTOMER:
                customerManager.deleteCustomer();
                break;
        }
    }
}
