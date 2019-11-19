/**
 * This class handles the Screen portion of the ATM.
 * It has methods to display messages on the ATM screen.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class Screen {

    public void displayMessage(String message){
        System.out.print(message);
    }

    public void displayMessageLine(String message){
        System.out.println(message);
    }

    public void displayDollarAmount(double amount){
        System.out.printf("$%,.2f", amount);
    }
}
