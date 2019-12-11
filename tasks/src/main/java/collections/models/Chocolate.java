package collections.models;

public class Chocolate extends Sweets {
    private ChocolateType type;

    public enum ChocolateType {
        WHITE, DARK, MILK
    }

    public Chocolate() {
        super();
    }

    public Chocolate(String name, double price, double weight, int sugarConcentration, ChocolateType type) {
        super(name, price, weight, sugarConcentration);
        this.type = type;
    }

    public ChocolateType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Chocolate " + super.toString() + ", type - " + getType().toString();
    }
}
