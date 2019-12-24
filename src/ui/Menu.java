package ui;

public class Menu {

    AppMenu customerMenu = new CustomerMenu();
    AppMenu mainMenu = new MainMenu();

    public void runMenu() {
        int selection;

        while ((selection = mainMenu.menu()) != 0) {
            mainMenu.returnPointMenu(selection);
            if (selection == 3) {
                while ((selection = customerMenu.menu()) != 0) {
                    customerMenu.returnPointMenu(selection);
                }
            }
        }
    }
}
