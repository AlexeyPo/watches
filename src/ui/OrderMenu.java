package ui;

import manage.OrdersManager;

import static ui.MainMenu.*;

public class OrderMenu implements AppMenu {

    private OrdersManager ordersManager = new OrdersManager();
    @Override
    public void printMenu() {
        System.out.println("========= Order Menu =========");
        System.out.println("1. Add new order");
        System.out.println("0. Back to main menu");
        System.out.println("=================================");
    }

    @Override
    public void returnPointMenu(int selection) {
        if (selection == ADD_NEW){
            ordersManager.addNewOrder();
        }
    }
}
