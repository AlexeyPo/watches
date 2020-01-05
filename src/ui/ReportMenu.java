package ui;

import manage.ReportsManager;

public class ReportMenu implements AppMenu {

    private ReportsManager reportsManager = new ReportsManager();

    public static final int FIRST_REPORT = 1;
    public static final int SECOND_REPORT = 2;
    public static final int THIRD_REPORT = 3;
    public static final int FOURTH_REPORT = 4;

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
        switch (selection) {
            case FIRST_REPORT:
                reportsManager.showTrademarkByWatchType();
                break;
            case SECOND_REPORT:
                reportsManager.showWatchByPrice();
                break;
            case THIRD_REPORT:
                reportsManager.showTrademarkByCountry();
                break;
            case FOURTH_REPORT:
                reportsManager.showVendorByTotalAmount();
                break;
        }
    }
}
