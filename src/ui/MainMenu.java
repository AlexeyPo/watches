package ui;

import manage.CountriesManager;
import manage.CustomerManager;
import manage.VendorsManager;

public class MainMenu implements AppMenu {

    public static final int COUNTRIES = 1;
    public static final int VENDORS = 2;
    public static final int CUSTOMERS = 3;

    private CountriesManager countriesManager = new CountriesManager();
    private CustomerManager customerManager = new CustomerManager();
    private VendorsManager vendorsManager = new VendorsManager();

    @Override
    public void printMenu() {
        System.out.println("============ Main Menu ==========");
        System.out.println("1. Countries");
        System.out.println("2. Vendors");
        System.out.println("3. Customers");
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
        }
    }
}
