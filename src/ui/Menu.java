package ui;

import static ui.MainMenu.*;

public class Menu {

    AppMenu mainMenu = new MainMenu();
    AppMenu customerMenu = new CustomerMenu();
    AppMenu itemMenu = new ItemMenu();
    AppMenu orderMenu = new OrderMenu();
    AppMenu reportMenu = new ReportMenu();

    public void runMenu() {
        int selection;

        while ((selection = mainMenu.menu()) != 0) {
            mainMenu.returnPointMenu(selection);
            switch (selection) {
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
                case REPORTS:
                    while ((selection = reportMenu.menu()) != 0) {
                        reportMenu.returnPointMenu(selection);
                    }
                    break;
            }
        }
    }
}
