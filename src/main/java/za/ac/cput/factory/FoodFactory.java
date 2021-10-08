package za.ac.cput.factory;

/**
 * FoodFactory.java
 * Factory class for the Login
 * Author: ??
 * Date: 8 October 2021
 **/

import za.ac.cput.entity.Food;

public class FoodFactory {

    public static Food createFood(int foodId, String category,String name, double price)
    {
        return new Food.Builder().setFoodId(foodId)
                .setCategory(category)
                .setName(name)
                .setPrice(price)
                .build();
    }
}
