package ui;

import manage.CountriesManager;

import static ui.MainMenu.ADD_NEW;

public class CountryMenu implements AppMenu {

    CountriesManager countriesManager = new CountriesManager();
    @Override
    public void printMenu() {
        System.out.println("========= Country Menu ==========");
        System.out.println("1. Add new Country");
        System.out.println("0. Back to main menu");
        System.out.println("=================================");
    }

    @Override
    public void returnPointMenu(int selection) {
        if (selection == ADD_NEW){
            countriesManager.addNewCountry();
        }
    }
}
