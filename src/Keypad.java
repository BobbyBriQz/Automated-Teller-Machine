import java.util.Scanner;

/**
 * This class handles the keypad portion of the ATM.
 * It has methods to get user input from the keyboard.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class Keypad {

    private Scanner input;

    public Keypad(){
        input = new Scanner(System.in);
    }

    public int getInput(){

        return input.nextInt();
    }
}
