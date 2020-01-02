package model;

import java.time.LocalDateTime;

public class Order {
    private int id;
    private LocalDateTime dateTime;
    private double totalAmount;
    private Customer customer;
    private Item item;
    private int quantityInOrder;

    public Order(int id, LocalDateTime dateTime, double totalAmount, Customer customer, Item item, int quantityInOrder) {
        this.id = id;
        this.dateTime = dateTime;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.item = item;
        this.quantityInOrder = quantityInOrder;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                ", item=" + item +
                ", quantityInOrder=" + quantityInOrder +
                '}';
    }
}
