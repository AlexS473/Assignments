import java.util.ArrayList;

/**
 * Combo class
 * Stores the contents of each Combo
 */
public class Combo implements Snack {

    /**
     * The id number of a particular snack combo
     */
    private int id;

    /**
     * The name of the snack combo
     */
    private String name;

    /**
     * The price of the snack combo
     */
    private double price;

    /**
     * The number of items making up the snack combo
     */
    private int numItems;

    /**
     * A count of the number of combos added
     */
    private static int scount;

    /**
     * The list of snack items or combos in the combo
     */
    private ArrayList<Snack> ComboList = new ArrayList<Snack>();

    //Constructor

    public Combo(){

        this.id = 100000 + (scount*100000);
        this.name = "Combo" + (scount+1);
        this.price = 0;
        this.ComboList=new ArrayList<>();
        scount++;
    }

    //Adds snacks and combos to the combo
    public void addSnack(Snack s){
        this.ComboList.add(s);
        this.price= calcprice();
        this.numItems++;
    }

    //Calculates the combo price as each item is entered
    private double calcprice(){
        double sntotal=0, total = 0;
        int n = 0;
        while(n < this.ComboList.size()){
            Snack sn = this.ComboList.get(n);
            if(sn instanceof Item){
                sntotal = sntotal + sn.getPrice();
            }
            else{
                total=total + sn.getPrice();
            }
            n++;
        }
        return total + (sntotal*.8);
    }

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
        return this.ComboList.size();
    }

    @Override
    public String getDetails() {
        int cc = 0;
        Snack s=null;
        String output = null;

        while(cc < this.getNumItems()){
            s = this.ComboList.get(cc);
            if(cc==0){
                output=s.getName();
            }
            else {
                output = output +", "+ s.getName();
            }
            cc++;
        }
        return this.name + " ("+output+") $" + this.price;

    }
}
