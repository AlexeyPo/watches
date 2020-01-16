package manage;

import dao.ItemDAO;
import model.Item;
import model.Trademark;
import model.WatchType;

import java.util.List;
import java.util.Scanner;

public class ItemsManager {

    ItemDAO itemDAO = new ItemDAO();
    Scanner scanner = new Scanner(System.in);

    public void showItems() {
        System.out.println("------------------------------- Items ---------------------------------");
        System.out.printf("%15s || %10s || %10s || %10s || Available\n", "Model", "Trademark", "Watch Type", "Price");
        List<Item> items = itemDAO.showListOfItems();

        items.forEach(item -> System.out.printf("%15s || %10s || %10s || %10.2f || %2d pcs\n", item.getModel(),
                item.getTrademark(), item.getWatchType(), item.getPrice(), item.getQuantity()));
        System.out.println("-----------------------------------------------------------------------");
    }

    public void addNewItem() {

        System.out.println("Please, enter watch model: ");
        String model = scanner.next();

        if (!itemDAO.itemIsAvailable(model)) {
            System.out.println("Please, enter price: ");
            double price = scanner.nextDouble();

            System.out.println("Please, enter quantity of watch available in warehouse: ");
            int quantity = scanner.nextInt();

            System.out.println("Please, enter trademark ID: ");
            int trademark = scanner.nextInt();

            System.out.println("Please, enter watchType ID: ");
            int watchType = scanner.nextInt();

            itemDAO.addNewItem(new Item(model, price, quantity, new Trademark(trademark), new WatchType(watchType)));
            showItems();
            System.out.println("The item was successfully updated");
        } else {
            showItems();
            System.out.println("Such model already exist");
        }

    }

    public void editItem() {
        System.out.println("Please, enter Item's model for changing: ");
        String model = scanner.next();

        if (itemDAO.itemIsAvailable(model)) {
            System.out.println("Please, enter Item's new Watch Type ID: ");
            int watchType = scanner.nextInt();

            System.out.println("Please, enter Item's new price: ");
            double price = scanner.nextDouble();

            itemDAO.editItem(model, watchType, price);
            showItems();
            System.out.println("The item was successfully updated");

        } else {
            showItems();
            System.out.println("!!!!!Item with mentioned model was not found!!!!!");
        }
    }
}
