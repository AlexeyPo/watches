package ui;

import static ui.MainMenu.*;

public class Menu {

//        System.out.println("============ Main Menu ==========");
//        System.out.println("1. Countries");+++++++
//        System.out.println("2. Vendors");
//        System.out.println("3. Customers");+++++++
//        System.out.println("4. Items list");++++++
//        System.out.println("5. Orders");+++++
//        System.out.println("6. Reports");
//        System.out.println("0. Exit");
//        System.out.println("=================================");

    AppMenu mainMenu = new MainMenu();
    AppMenu countryMenu = new CountryMenu();
    AppMenu customerMenu = new CustomerMenu();
    AppMenu itemMenu = new ItemMenu();
    AppMenu orderMenu = new OrderMenu();

    public void runMenu() {
        int selection;

        while ((selection = mainMenu.menu()) != 0) {
            mainMenu.returnPointMenu(selection);
            switch (selection) {
                case COUNTRIES:
                    while ((selection = countryMenu.menu()) != 0){
                        countryMenu.returnPointMenu(selection);
                    }
                    break;
                case CUSTOMERS:
                    while ((selection = customerMenu.menu()) != 0) {
                        customerMenu.returnPointMenu(selection);
                    }
                    break;
                case ITEMS:
                    while ((selection = itemMenu.menu()) != 0) {
                        itemMenu.returnPointMenu(selection);
                    }
                    break;
                case ORDERS:
                    while ((selection = orderMenu.menu()) != 0) {
                        orderMenu.returnPointMenu(selection);
                    }
                    break;
            }
        }
    }
}
