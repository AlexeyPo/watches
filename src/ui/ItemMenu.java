package ui;

import manage.ItemsManager;

import static ui.MainMenu.*;

public class ItemMenu implements AppMenu {

private ItemsManager itemsManager = new ItemsManager();

    @Override
    public void printMenu() {
        System.out.println("========= Item Menu =========");
        System.out.println("1. Add new item");
        System.out.println("2. Edit item");
        System.out.println("0. Back to main menu");
        System.out.println("=================================");
    }

    @Override
    public void returnPointMenu(int selection) {
        switch (selection) {
            case ADD_NEW:
                itemsManager.addNewItem();
                break;
            case EDIT:
                itemsManager.editItem();
                break;
        }
    }
}
