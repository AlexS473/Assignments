import java.util.ArrayList;

/**
 * Order Class
 *
 * Contains the details of each order including items and payment details
 *
 * @author Shereece A. A. Victor
 * 816001671
 */
public class Order{

    /**
     * The type of payment method to be used, cash or card
     */
    private String type;

    /**
     * The expiry year of the card to be used for payment
     */
    private int year=0;

    /**
     * The expiry month of the card used for payment
     */
    private int month=0;

    /**
     * The amount of cash tendered by the customer
     */
    private double cash=0;

    /**
     * The total cost of items
     */
    private double cost=0;

    /**
     * The list of snacks in the order
     */
    private ArrayList<Snack> snacks;

    /**
     * The payment strategy to be used
     */
    private Payment paymenttype;

    //Constructors

    /**
     * Constructor for card orders
     * @param type payment type for order
     * @param year the expiry year of the card used for payment
     * @param month the expiry month of the card used for payment
     */
     public Order (String type, int year, int month){
        this.type = type;
        this.year = year;
        this.month = month;
        snacks = new ArrayList<Snack>();
        this.paymenttype= new Card_Payment();
    }

    /**
     * Constuctor for Cash orders
     * @param type payment type for order
     * @param cash the cash tendered by the customer
     */
    public Order (String type, double cash){
        this.type = type;
        this.cash = cash;
        snacks = new ArrayList<Snack>();
        this.paymenttype = new Cash_Payment();
    }

    //Accessors
    public Payment getPaymenttype() {
        return paymenttype;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public double getCash() {
        return cash;
    }

    public double getCost() {
        return cost;
    }

    //Public Methods

    //Adds snacks or combos chosen to the order created
    public void addtoOrder(Snack s){
        this.snacks.add(s);
        this.cost= this.cost + s.getPrice();
    }

    //Used to easily print the snacks in the order
    public String toString (){
        int oc = 0;
        Snack s=null;
        String output = null;

        while(oc < this.snacks.size()){
            s = this.snacks.get(oc);
            if(oc==0){
                output=s.getDetails()+" ";
            }
            else {
                output = output + s.getDetails() + ("  ");
            }
            oc++;
        }
        return output;
    }

    //Prints the receipt from successful payment
    public void printReceipt(){

        String output = "\nOrder Receipt\n__________________________________\n";

        output = output + "Snacks purchased: "+ this + "\n";

        if(this.type.compareTo("CASH")==0) {
            output = output + "Cash tendered: $" + this.cash + "\n";

            double change = this.cash - this.cost;

            output = output + "Change received: $" + change + "\n";
        }
        else{
            output = output + "Paid with card.\n";
        }

        System.out.println(output);

    }


}
