package collectionsMainTask.models;

public class Biscuits extends Sweets {
    public enum BiscuitsType {
        ROLLED, DROP, SCONES
    }
    private BiscuitsType biscuitsTypeBiscuits;

    public Biscuits() {
        super();
    }

    public Biscuits(String name, double price, double weight, int sugarConcentration, BiscuitsType biscuitsTypeBiscuits) {
        super(name, price, weight, sugarConcentration);
        this.biscuitsTypeBiscuits = biscuitsTypeBiscuits;
    }

    public BiscuitsType getTypeBiscuits() {
        return biscuitsTypeBiscuits;
    }

    @Override
    public String toString() {
        return "Biscuits " + super.toString() + ", type - " + getTypeBiscuits().toString();
    }
}
