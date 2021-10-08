package za.ac.cput.entity;

public class Food {

    private int foodId;
    private String category,name;
    private double price;

    protected Food() {}

    private Food(Builder builder)
    {
        this.foodId = builder.foodId;
        this.category = builder.category;
        this.name = builder.name;
        this.price = builder.price;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Builder
    public static class Builder{

        private int foodId;
        private String  category ,name;
        private double price;

        public Builder setFoodId(int foodId) {
            this.foodId = foodId;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Food build()
        {
            return new Food(this);
        }

        public Builder copy(Food food)
        {
            this.foodId = food.foodId;
            this.category = food.category;
            this.name = food.name;
            this.price = food.price;

            return this;
        }
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
