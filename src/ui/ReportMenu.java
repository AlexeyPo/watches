package ui;

import manage.ReportsManager;

public class ReportMenu implements AppMenu {

    private ReportsManager reportsManager = new ReportsManager();

    @Override
    public void printMenu() {
        System.out.println("========== Report Menu ==========");
        System.out.println("1. Вывести марки заданного типа часов");
        System.out.println("2. Вывести информацию о механических часах, цена на которые не превышает заданную");
        System.out.println("3. Вывести марки часов, изготовленных в заданной стране");
        System.out.println("4. Вывести производителей, общая сумма часов которых в магазине не превышает заданную");
        System.out.println("0. Back to main menu");
        System.out.println("=================================");
    }

    @Override
    public void returnPointMenu(int selection) {
        switch (selection){
            case 1:
                reportsManager.showTrademarkByWatchType();
                break;
            case 2:
                reportsManager.showWatchByPrice();
                break;
            case 3:
                reportsManager.showTrademarkByCountry();
                break;
            case 4:
                reportsManager.showVendorByTotalAmount();
                break;
        }

    }
}
