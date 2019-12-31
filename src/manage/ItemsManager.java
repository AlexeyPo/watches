package manage;

import dao.ItemDAO;
import model.Item;

public class ItemsManager {

    ItemDAO itemDAO = new ItemDAO();

    public void showItems() {
        System.out.println("------------ Items --------------");
        for (Item item : itemDAO.findListOfItems()) {
            System.out.printf("model: %15s || Trademark: %10s || watchType: %10s || price %10.2f || available: %2d pcs.\n",
                    item.getModel(), item.getTrademark(), item.getWatchType(), item.getPrice(), item.getQuantity());
        }
        System.out.println("---------------------------------");
    }
}
