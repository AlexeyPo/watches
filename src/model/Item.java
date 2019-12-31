package model;

public class Item {
    private int id;
    private String model;
    private double price;
    private int quantity;

    private Trademark trademark;
    private WatchType watchType;

    public Item(int id, String model, double price, int quantity, Trademark trademark, WatchType watchType) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.trademark = trademark;
        this.watchType = watchType;
    }

    public Item(String model, double price, int quantity, Trademark trademark, WatchType watchType) {
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.trademark = trademark;
        this.watchType = watchType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Trademark getTrademark() {
        return trademark;
    }

    public void setTrademark(Trademark trademark) {
        this.trademark = trademark;
    }

    public WatchType getWatchType() {
        return watchType;
    }

    public void setWatchType(WatchType watchType) {
        this.watchType = watchType;
    }
}
