package manage;

import dao.OrderDAO;
import model.Order;

public class OrdersManager {

    OrderDAO orderDAO = new OrderDAO();

    public void showOrders() {
        System.out.println("---------------------------------------- Orders -----------------------------------------");
        System.out.printf("%19s || %15s || %7s || %10s || %15s || %10s || %9s || %3s || %8s || %9s\n",
                "Date and time", "Customer's Name", "Card ID", "Trademark", "Model", "Watch Type", "Price", "Qty",
                "Discount", "Amount");

        for (Order order : orderDAO.showListOfOrders()) {
            System.out.printf("%td.%tm.%tY %tT || %15s || %7d || %10s || %15s || %10s || %9.2f || %3d || %8.1f || %9.2f\n",
                    order.getDateTime(), order.getDateTime(), order.getDateTime(), order.getDateTime(),
                    order.getCustomer().getName(), order.getCustomer().getCardNumber(), order.getTrademark(),
                    order.getItem().getModel(), order.getWatchType(), order.getItem().getPrice(),
                    order.getQuantityInOrder(), order.getCustomer().getPersonalDiscount(), order.getAmount());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void addNewOrder() {

    }
}
