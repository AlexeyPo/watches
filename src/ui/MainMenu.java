package ui;

import manage.*;

public class MainMenu implements AppMenu {

    public static final int COUNTRIES = 1;
    public static final int VENDORS = 2;
    public static final int CUSTOMERS = 3;
    public static final int ITEMS = 4;
    public static final int ORDERS = 5;
    public static final int REPORTS = 6;

    private CountriesManager countriesManager = new CountriesManager();
    private CustomerManager customerManager = new CustomerManager();
    private VendorsManager vendorsManager = new VendorsManager();
    private ItemsManager itemsManager = new ItemsManager();
    private OrdersManager ordersManager = new OrdersManager();
    private ReportsManager reportsManager = new ReportsManager();


    @Override
    public void printMenu() {
        System.out.println("============ Main Menu ==========");
        System.out.println("1. Countries");
        System.out.println("2. Vendors");
        System.out.println("3. Customers");
        System.out.println("4. Items list");
        System.out.println("5. Orders");
        System.out.println("6. Reports");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }

    @Override
    public void returnPointMenu(int selection) {
        switch (selection) {
            case COUNTRIES:
                countriesManager.showCountries();
                break;
            case VENDORS:
                vendorsManager.showVendor();
                break;
            case CUSTOMERS:
                customerManager.showCustomers();
                break;
            case ITEMS:
                itemsManager.showItems();
                break;
            case ORDERS:
                ordersManager.showOrders();
                break;
            case REPORTS:
                reportsManager.showReports();
                break;
        }
    }
}
