package model;

public class Customer {
    private int id;
    private String name;
    private double sum;
    private int cardNumber;

    public Customer(int id, String name, double sum, int cardNumber) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.cardNumber = cardNumber;
    }

    public Customer(String name, double sum, int cardNumber) {
        this.name = name;
        this.sum = sum;
        this.cardNumber = cardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
