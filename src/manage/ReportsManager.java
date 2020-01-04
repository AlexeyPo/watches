package manage;

import dao.TrademarkDAO;

import java.util.Scanner;

public class ReportsManager {

    TrademarkDAO trademarkDAO = new TrademarkDAO();
    Scanner scanner = new Scanner(System.in);

    public void showReports() {
        System.out.println("-------- Reports --------------");
//        for (Customer customer : customerDAO.findListOfCustomers()) {
//            System.out.printf("id: %d || Second Name: %8s || total sum: %5.2f || personal discount %2.2f %% || card ID: %d\n", customer.getId(),
//                    customer.getName(), customer.getTotalSum(), customer.getPersonalDiscount(), customer.getCardNumber());
//        }
        System.out.println("---------------------------------");
    }

    public void showTrademarkByWatchType() {
        System.out.println("Please choose watch type ID for filter: 1 - quartz, 2- mechanical, 3 - electronic");
        int id = scanner.nextInt();
        trademarkDAO.showTrademarksByWatchType(id);
    }

    public void showWatchByPrice() {

    }

    public void showTrademarkByCountry() {

    }

    public void showVendorByTotalAmount() {

    }
}
