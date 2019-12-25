package manage;

import dao.VendorDAO;
import model.Vendor;

public class VendorsManager {

    VendorDAO vendorDAO = new VendorDAO();

    public void showVendor() {
        System.out.println("---------- Vendors --------------");
        for (Vendor vendor : vendorDAO.showListOfVendors()) {
            System.out.printf("id: %3d || title: %s\n", vendor.getId(), vendor.getTitle());
        }
        System.out.println("---------------------------------");
    }
}
