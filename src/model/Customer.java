package model;

public class Customer {
    private int id;
    private String name;
    private double totalSum;
    private double personalDiscount;
    private int cardNumber;

    public Customer(int id, String name, double totalSum, double personalDiscount, int cardNumber) {
        this.id = id;
        this.name = name;
        this.totalSum = totalSum;
        this.personalDiscount = personalDiscount;
        this.cardNumber = cardNumber;
    }

    public Customer(String name, double totalSum, int cardNumber) {
        this.name = name;
        this.totalSum = totalSum;
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

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(double personalDiscount) {
        this.personalDiscount = personalDiscount;
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
                ", totalSum=" + totalSum +
                ", personalDiscount=" + personalDiscount +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
