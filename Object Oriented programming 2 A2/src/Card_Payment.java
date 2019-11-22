import java.util.Calendar;

/**
 * Card Payment Class
 *
 * Processes payments made via card
 */
public class Card_Payment implements Payment {

    //Checks to see if the card entered is valid
    public boolean validatePayment(Order order){
        int yearnow = Calendar.getInstance().get(Calendar.YEAR);
        int monthnow = Calendar.getInstance().get(Calendar.MONTH);
        if( order.getYear() >= yearnow){
            if(order.getMonth() >= monthnow){
                System.out.println("Card payment accepted.\n");
                return true;
            }
        }
        System.out.println("Card declined.\n");
        return false;
    }
}
