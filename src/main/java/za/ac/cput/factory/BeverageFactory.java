package za.ac.cput.factory;

import za.ac.cput.entity.Beverage;

/*
    BeverageFactory.java
    beverage Factory
    Author: Nonhlahla Hlungwani (218160658)
    Date: 7 October 2021
 */
public class BeverageFactory {

    public static Beverage createBeverage(int bevCode, String bevName, String category, double price) {

        return new Beverage.Builder()
                .setBevCode(bevCode)
                .setBevName(bevName)
                .setCategory(category)
                .setPrice(price)
                .build();


    }
}

