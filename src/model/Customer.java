package model;

public class Customer {
    private int id;
    private String name;
    private double totalSum;
    private double personalDiscount;
    private int cardNumber;

    private Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.totalSum = builder.totalSum;
        this.personalDiscount = builder.personalDiscount;
        this.cardNumber = builder.cardNumber;
    }

    public static class Builder {
        private int id;
        private String name;
        private double totalSum;
        private double personalDiscount;
        private int cardNumber;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withTotalSum(double totalSum) {
            this.totalSum = totalSum;
            return this;
        }

        public Builder withPersonalDiscount(double personalDiscount) {
            this.personalDiscount = personalDiscount;
            return this;
        }

        public Builder withCardNumber(int cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
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
