package collections.models;

public class Sweets {
    private String name;
    private double price;
    private double weight;
    private int sugarConcentration;

    public Sweets() {
        super();
    }

    public Sweets(String name, double price, double weight, int sugarConcentration) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sugarConcentration = sugarConcentration;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getSugarConcentration() {
        return sugarConcentration;
    }

    @Override
    public String toString() {
        return  "name=: " + name + ", cost=" + price + ", weight=" + weight + ", sugar concentration=" + sugarConcentration;
    }
}
