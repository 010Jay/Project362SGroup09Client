package za.ac.cput.factory;

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
