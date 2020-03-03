/**
 * Cash Payment Class
 *
 * Processes Cash payments
 */
public class Cash_Payment implements Payment {
    //Checks is the cash entered is sufficient and issues change
    public boolean validatePayment(Order order){
        double bills=0;
        Double convert;
        int value;

        System.out.println("$" + order.getCash() + " tendered.\n");
        if(order.getCash() >= order.getCost()){
            System.out.println("Sufficient cash received.\n");

            //Calculating and issuing physical change
            if (order.getCash() > order.getCost()){
                double change = order.getCash() - order.getCost();

            int cash[] = {20,10,5,1};
            for (int i : cash) {
                if (change >= i) {
                    bills = change / i;
                    convert = new Double(bills);
                    value = convert.intValue();
                    change = change - (value * i);
                    if (value>0) {
                        System.out.println(value + " " + i + " dollar bills returned.\n");
                    }
                }
            }

            int coin[] = {25,10,5,1};
            for (int i: coin) {
                if (change >= (i/100)) {
                    bills = change / (i/100);
                    convert = new Double(bills);
                    value = convert.intValue();
                    change = change - (value * (i/100));
                    if(value >0) {
                        System.out.println(value + " " + i + " cents returned.\n");
                    }
                }
            }


            }
            return true;
        }

        System.out.println("Insufficient cash received.\n");
        return false;
    }


}
