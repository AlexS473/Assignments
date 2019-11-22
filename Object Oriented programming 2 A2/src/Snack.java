/**
 * Snack Interface
 *
 * Outlines the methods to be implemented for snacks
 */
public interface Snack {
    /**
     * The Id of a snack
     * @return id
     */
    public int getID( );

    /**
     * The name of a snack
     * @return name
     */
    public String getName( );

    /**
     * The price of a snack
     * @return price
     */
    public double getPrice( );

    /**
     * The number of items that make up a snack
     * @return numItems
     */
    public int getNumItems( );

    /**
     * The string representation of a snack
     * @return description
     */
    public String getDetails( );
}
