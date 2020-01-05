package manage;

import dao.VendorDAO;
import model.Vendor;

public class VendorsManager {

    VendorDAO vendorDAO = new VendorDAO();

    public void showVendor() {
        System.out.println("---------- Vendors --------------");
        System.out.printf("%2s || %s\n", "id", "Vendor title");

        for (Vendor vendor : vendorDAO.showListOfVendors()) {
            System.out.printf("%2d || %s\n", vendor.getId(), vendor.getTitle());
        }
        System.out.println("---------------------------------");
    }
}
