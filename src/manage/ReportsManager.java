package manage;

import dao.CountryDAO;
import dao.ItemDAO;
import dao.TrademarkDAO;
import dao.VendorDAO;
import model.Item;
import model.Trademark;
import model.Vendor;

import java.util.List;
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
        List<Trademark> trademarks = trademarkDAO.showTrademarksByWatchType(id);

        trademarks.forEach(trademark -> System.out.printf("%10s\n", trademark.getTitle()));
        System.out.println("------------------------------------------");
    }

    public void showWatchByPrice() {
        System.out.println("Please enter price for filter: ");
        double price = scanner.nextInt();

        showReports();
        System.out.printf("%15s || %10s || %10s || %10s || Available\n", "Model", "Trademark", "Watch Type", "Price");
        List<Item> items = itemDAO.showWatchByPrice(price);

        items.forEach(item -> System.out.printf("%15s || %10s || %10s || %10.2f || %2d pcs\n", item.getModel(),
                item.getTrademark(), item.getWatchType(), item.getPrice(), item.getQuantity()));
        System.out.println("------------------------------------------");
    }

    public void showTrademarkByCountry() {
        System.out.println("Please enter country for filter: ");
        String country = scanner.nextLine();

        if (countryDAO.countryIsAvailable(country)) {
            showReports();
            System.out.printf("%10s\n", "Trademark");
            List<Trademark> trademarks = trademarkDAO.showTrademarkByCountry(country);

            trademarks.forEach(trademark -> System.out.printf("%10s\n", trademark.getTitle()));
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
        List<Vendor> vendors = vendorDAO.showVendorByTotalAmount(amount);

        vendors.forEach(vendor -> System.out.printf("%10s\n", vendor.getTitle()));
        System.out.println("------------------------------------------");
    }
}
