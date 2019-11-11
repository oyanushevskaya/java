package collectionsMainTask.models;

public class Candy extends Sweets {
    public enum CandyType {
        CARAMEL, LOLLIPOPS, JELLY
    }
    private CandyType candyTypeCandy;

    public Candy() {
        super();
    }

    public Candy(String name, double price, double weight, int sugarConcentration, CandyType candyTypeCandy) {
        super(name, price, weight, sugarConcentration);
        this.candyTypeCandy = candyTypeCandy;
    }

    public CandyType getTypeCandy() {
        return candyTypeCandy;
    }

    @Override
    public String toString() {
        return "Candy " + super.toString() + ", type - " + getTypeCandy().toString();
    }
}
