/**
 * Cafeteria Class
 * Holds the main method
 * @author Shereece A. A. Victor
 * 816001671
 */
public class Cafeteria {

    public static void main(String[] args) {

        Vending_Machine vm = new Vending_Machine();
        vm.load_Machine(); //Add the items from the file to the vending machine object
        vm.show_contents(); // Displays the contents of the Vending Machine
        vm.load_orders(); // Adds the orders from the file to the vending machine
        vm.process_Orders(); // Processes the orders entered

        /*
        DISCLAIMER:
        This program was implemented to practice design strategies and thus
        does not focus on catering for every error scenario and was not vigorously tested.
        Please do not test with invalid test cases.
        It also isn't as efficient and well designed as it ideally can be. Thank you for your consideration.
        -Shereece
         */
    }
}