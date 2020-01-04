package model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private LocalDateTime dateTime;
    private double amount;
    private Customer customer;
    private Item item;
    private int quantityInOrder;
    private Trademark trademark;
    private WatchType watchType;

    public Order(int id, LocalDateTime dateTime, double amount, Customer customer, Item item, int quantityInOrder) {
        this.id = id;
        this.dateTime = dateTime;
        this.amount = amount;
        this.customer = customer;
        this.item = item;
        this.quantityInOrder = quantityInOrder;
    }

    public Order(LocalDateTime dateTime, double amount, int quantityInOrder, Customer customer, Item item, Trademark trademark, WatchType watchType) {
        this.dateTime=dateTime;
        this.amount=amount;
        this.quantityInOrder=quantityInOrder;
        this.customer=customer;
        this.item=item;
        this.trademark=trademark;
        this.watchType=watchType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantityInOrder() {
        return quantityInOrder;
    }

    public void setQuantityInOrder(int quantityInOrder) {
        this.quantityInOrder = quantityInOrder;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", amount=" + amount +
                ", customer=" + customer +
                ", item=" + item +
                ", quantityInOrder=" + quantityInOrder +
                ", trademark=" + trademark +
                ", watchType=" + watchType +
                '}';
    }
}
