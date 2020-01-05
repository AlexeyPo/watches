package manage;

import dao.CountryDAO;
import dao.ItemDAO;
import dao.TrademarkDAO;
import dao.VendorDAO;
import model.Item;
import model.Trademark;
import model.Vendor;

import java.util.Scanner;

public class ReportsManager {

    TrademarkDAO trademarkDAO = new TrademarkDAO();
    ItemDAO itemDAO = new ItemDAO();
    CountryDAO countryDAO = new CountryDAO();
    VendorDAO vendorDAO = new VendorDAO();
    Scanner scanner = new Scanner(System.in);

    public void showReports() {
        System.out.println("---------- Reports --------------");
    }


    public void showTrademarkByWatchType() {
        System.out.println("Please choose watch type ID for filter: 1 - quartz, 2- mechanical, 3 - electronic");
        int id = scanner.nextInt();

        showReports();
        System.out.printf("%10s\n", "Trademark");

        for (Trademark trademark : trademarkDAO.showTrademarksByWatchType(id)) {
            System.out.printf("%10s\n", trademark.getTitle());
        }
        System.out.println("------------------------------------------");
    }

    public void showWatchByPrice() {
        System.out.println("Please enter price for filter: ");
        double price = scanner.nextInt();

        showReports();
        System.out.printf("%15s || %10s || %10s || %10s || Available\n", "Model", "Trademark", "Watch Type", "Price");

        for (Item item : itemDAO.showWatchByPrice(price)) {
            System.out.printf("%15s || %10s || %10s || %10.2f || %2d pcs\n",
                    item.getModel(), item.getTrademark(), item.getWatchType(), item.getPrice(), item.getQuantity());
        }
        System.out.println("------------------------------------------");
    }

    public void showTrademarkByCountry() {
        System.out.println("Please enter country for filter: ");
        String country = scanner.next();

        if (countryDAO.countryIsAvailable(country)) {
            showReports();
            System.out.printf("%10s\n", "Trademark");

            for (Trademark trademark : trademarkDAO.showTrademarkByCountry(country)) {
                System.out.printf("%10s\n", trademark.getTitle());
            }
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Such country was not found!!");
        }
    }

    public void showVendorByTotalAmount() {
        System.out.println("Please enter vendor name for filter: ");
        double amount = scanner.nextDouble();

        showReports();
        System.out.printf("%s\n", "Vendor");

        for (Vendor vendor : vendorDAO.showVendorByTotalAmount(amount)) {
            System.out.printf("%10s\n", vendor.getTitle());
        }

        System.out.println("------------------------------------------");
    }
}
