package manage;

import dao.VendorDAO;
import model.Vendor;

import java.util.List;

public class VendorsManager {

    VendorDAO vendorDAO = new VendorDAO();

    public void showVendor() {
        System.out.println("---------- Vendors --------------");
        System.out.printf("%2s || %s\n", "id", "Vendor title");
        List<Vendor> vendors = vendorDAO.showListOfVendors();

        vendors.forEach(vendor -> System.out.printf("%2d || %s\n", vendor.getId(), vendor.getTitle()));
        System.out.println("---------------------------------");
    }
}
