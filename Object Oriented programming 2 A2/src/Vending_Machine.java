import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Vending_Machine Class
 *
 * Captures the fuctionality of a vending machine
 */
public class Vending_Machine {

    public ArrayList<Item> Items;
    public ArrayList<Combo> Combos;
    public ArrayList<Order> Orders;

    public Vending_Machine() {
        this.Items = new ArrayList<>();
        this.Combos = new ArrayList<>();
        this.Orders = new ArrayList<>();
    }

    //Adds items and combos to the vending machine
    public void load_Machine(){


        //Opening the items file
        String filename = "items.txt";
        Scanner input = null;

        try {
            input = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("We could not find " + filename + " .");
            System.out.println("System terminating now.\n");
            System.exit(-1);
        }

        //Adding objects to the list from the file
        while (input.hasNext()){

            String name =input.next();
            double price= input.nextDouble();
            this.Items.add(new Item(name, price));
        }
        //closing input scanner
        input.close();

        //Opening the combos file
        String filename2 = "combos.txt";


        try {
            input = new Scanner(new File(filename2));
        }
        catch (FileNotFoundException e) {
            System.out.println("We could not find " + filename2 + " .");
            System.out.println("System terminating now.\n");
            System.exit(-1);
        }

        //Adding objects to the list from the file
        while (input.hasNext()){

            Combo c = new Combo(); //Create a blank combo
            String data = input.nextLine(); //Read in one line
            String ids[] = data.split(" "); //delimit by whitespace

            for (int y=0; y<ids.length; y++){
                int i = Integer.parseInt(ids[y]);
                if(i>=100000){
                    c.addSnack(this.findc(i));
                }
                else{
                    c.addSnack(this.findi(i));
                }
            }

            this.Combos.add(c);
        }
        //closing input scanner
        input.close();

    }

    //Displays the contents of the Vending machine
    public void show_contents(){
        int n = 0;
        System.out.println("This Vending Machine has the following Snack Items: \n ");

        if(this.Items.size()==0){
            System.out.println("No Snack items added.\n");
        }
        while(n < this.Items.size()){
            Item it = this.Items.get(n);
            System.out.println(it.getDetails()+"\n");
            n++;
        }
        System.out.println("This Vending Machine has the following Snack Combos: \n ");

        if(this.Combos.size()==0){
            System.out.println("No Snack combos added.\n");
        }
        n=0;
        while(n < this.Combos.size()){
            Combo c = this.Combos.get(n);
            System.out.println(c.getDetails()+"\n");
            n++;
        }
    }

    //Finds a previously added item
    public Item findi (int id){

        int r=0;
        while(r < this.Items.size()){
            Item it = this.Items.get(r);
            if(it.getID()==id){
                return it;
            }
            r++;
        }
        return null;
    }

    //Finds a previously added Combo
    public Combo findc (int id){

        int q=0;
        while(q < this.Combos.size()){
            Combo combo = this.Combos.get(q);
            if(combo.getID()==id){
                return combo;
            }
            q++;
        }
        return null;
    }

    //Loads orders into the vending machine
    public void load_orders(){

        //Opening the items file
        String filename = "orders.txt";
        Scanner input = null;

        try {
            input = new Scanner(new File(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("We could not find " + filename + " .");
            System.out.println("System terminating now.\n");
            System.exit(-1);
        }

        //Adding objects to the list from the file
        while (input.hasNext()){
            Order o = null;
            String orderdata = input.nextLine(); //Read in one line
            String info[] = orderdata.split(" "); //delimit by whitespace

            if (info[0].compareTo("CASH")==0){
                double d = Double.parseDouble(info[1]);
                o = new Order ("CASH", d);
            }
            else if(info[0].compareTo("CARD")==0){
                String date[] = info[1].split("-");
                o = new Order ("CARD", Integer.parseInt(date[0]), Integer.parseInt(date[1]));
            }
            else{
                System.out.println("Invalid Order type.\n"); //What do I do here
            }

            for (int e= 2; e<info.length; e++){

                int j = Integer.parseInt(info[e]);
                if(j>=100000){
                    o.addtoOrder(findc(j));
                }
                else{
                    o.addtoOrder(findi(j));
                }
            }

            Orders.add(o);
        }
        //closing input scanner
        input.close();
    }

    //Processes the payment and dispensing of each order entered.
    public void process_Orders(){

        int n=0;

        n=0;
        while(n < this.Orders.size()){
            Order o = this.Orders.get(n);
            System.out.println("Processing Order #"+ (n+1) + ".........\n" );
            System.out.println(o);

            if(o.getPaymenttype().validatePayment(o)){
                System.out.println("Dispensing order...\n");
                o.printReceipt();
            }
            else{
                System.out.println("Unable to dispense your order.\n");
            }

            n++;
        }
    }

}
