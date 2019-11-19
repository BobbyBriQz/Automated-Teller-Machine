/**
 * This class handles the deposit operation of the ATM.
 * It is a subclass of the abstract Transaction class.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class Deposit extends Transaction{

    private double amount;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private final static int CANCELED = 0;

    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase,
                   Keypad atmKeyPad, DepositSlot atmDepositSlot) {
        super(userAccountNumber, atmScreen, atmBankDatabase);

        keypad = atmKeyPad;
        depositSlot = atmDepositSlot;
    }

    /**
     * This method makes a deposit into the user's account
     */
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        amount = promptForDepositAmount();

        if(amount != CANCELED){

            screen.displayMessage("\nPlease insert a deposit envelope containing ");
            screen.displayDollarAmount(amount);
            screen.displayMessageLine(".");

            boolean envelopeReceived = depositSlot.isEnvelopeReceived();

            if (envelopeReceived){

                screen.displayMessageLine("\nYour envelope has been " +
                        "received.\nNOTE: The money just deposited will not be available " +
                        "until we verify the amount of any enclosed cash and your checks clear.");

                bankDatabase.credit(getAccountNumber(), amount);
            }else {
                screen.displayMessageLine("\nYou did not insert an envelope, so the ATM canceled " +
                        "your transaction.");
            }
        }else {

            screen.displayMessageLine("\nCanceling transaction...");
        }
    }

    /**
     *Method that prompts user to type in deposit amount or cancel deposit transaction
     * @return depositAmount
     */
    private double promptForDepositAmount() {
        double depositAmount;
        Screen screen = getScreen();

        screen.displayMessage("\nPlease enter a deposit amount in CENTS (or 0 to cancel): ");

        int input = keypad.getInput();

        if(input == CANCELED){
            depositAmount = CANCELED;
        }else {
            depositAmount = (double) input/100;
        }
        return depositAmount;
    }
}
