package za.ac.cput.entity;

/*
    Beverage.java
    beverage Entity with builder Pattern
    Author: Nonhlahla Hlungwani (218160658)
    Date: 7 October 2021
 */


public class Beverage {

    private int bevCode;
    private String bevName;
    private String category;
    private double price;

    public Beverage (Builder builder)
    {
        this.bevCode = builder.bevCode;
        this.bevName = builder.bevName;
        this.category =builder.category;
        this.price = builder.price;


    }
    public int getBevCode() {
        return bevCode;
    }

    public String getBevName() {
        return bevName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }



    public static class Builder{
        private int bevCode;
        private String bevName;
        private String category;
        private double price;



        public Builder setBevCode(int bevCode) {
            this.bevCode = bevCode;
            return this;
        }

        public Builder setBevName(String bevName) {
            this.bevName = bevName;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;

        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }


        public Beverage build()
        {
            return new Beverage(this);
        }


        public Builder copy(Beverage beverage)
        {
            this.bevCode = beverage.bevCode;
            this.bevName =  beverage.bevName;
            this.category =  beverage.category;
            this.price =  beverage.price;

            return this;
        }
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "bevCode=" + bevCode +
                ", bevName='" + bevName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

