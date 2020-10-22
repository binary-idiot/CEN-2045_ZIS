public class Species {

    private final String name;
    private final String info;
    private final String food;
    private final int amount;

    public Species(String name, String info, String food, int amount) {
        this.name = name;
        this.info = info;
        this.food = food;

        if(amount > 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Food amount: " + amount + " is invalid");
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Info: %s, Food: %s, Food Amount: %d",
                getName(), getInfo(), getFood(), getAmount());
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

    public int getAmount() {
        return amount;
    }
}
