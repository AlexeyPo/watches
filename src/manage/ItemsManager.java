package manage;

import dao.ItemDAO;
import model.Item;

public class ItemsManager {

    ItemDAO itemDAO = new ItemDAO();

    public void showItems() {
        System.out.println("------------------------------- Items ---------------------------------");
        System.out.printf("%15s || %10s || %10s || %10s || Available\n", "Model", "Trademark", "Watch Type", "Price");
        for (Item item : itemDAO.findListOfItems()) {
            System.out.printf("%15s || %10s || %10s || %10.2f || %2d pcs.\n",
                    item.getModel(), item.getTrademark(), item.getWatchType(), item.getPrice(), item.getQuantity());
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
