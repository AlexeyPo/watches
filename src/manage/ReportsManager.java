package manage;

import model.Customer;

public class ReportsManager {

    public void showReports() {
        System.out.println("-------- Customers --------------");
//        for (Customer customer : customerDAO.findListOfCustomers()) {
//            System.out.printf("id: %d || Second Name: %8s || total sum: %5.2f || personal discount %2.2f %% || card ID: %d\n", customer.getId(),
//                    customer.getName(), customer.getTotalSum(), customer.getPersonalDiscount(), customer.getCardNumber());
//        }
        System.out.println("---------------------------------");
    }
}