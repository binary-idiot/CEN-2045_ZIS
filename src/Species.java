import java.security.InvalidParameterException;

public class Species {

    private final String name;
    private final String info;
    private final String food;
    private final int foodAmount;

    public Species(String name, String info, String food, int foodAmount) {
        this.name = name;
        this.info = info;
        this.food = food;

        if(foodAmount > 0) {
            this.foodAmount = foodAmount;
        } else {
            throw new IllegalArgumentException("Food amount: " + foodAmount + " is invalid");
        }
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getFood() {
        return food;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
