/**
 * Item class
 * Contains information pertaining to each individual
 * snack item available from the vending machine.
 * @author Shereece A. A. Victor
 * ID:816001671
 */
public class Item implements Snack {

    /**
     * The id number of a particular snack item
     */
    private int id;

    /**
     * The name of the snack item
     */
    private String name;

    /**
     * The price of the snack item
     */
    private double price;

    /**
     * The number of items making up the snack
     */
    private static int numItems =1;

    /**
     * A count of the number of snacks added
     */
    private static int scount;

    //Constructor
    /**
     * Creates a new snack item
     * @param name The name of the snack
     * @param price the price of the snack
     */
    public Item(String name, double price) {
        this.id = 100 + (scount*100);
        this.name = name;
        this. price = price;
        scount++;
    }

    //Accessors and Mutators
    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getNumItems() {
        return this.numItems;
    }

    @Override
    public String getDetails() {
        return this.name + "    "+ "$" + this.price;

    }
}
