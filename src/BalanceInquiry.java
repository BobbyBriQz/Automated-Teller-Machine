/**
 * This class handles the balance inquiry operation of the ATM.
 * It is a subclass of the abstract Transaction class.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class BalanceInquiry extends Transaction{


    public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }

    /**
     * This method makes a balance inquiry for the user and displays it on screen.
     */
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

        double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

        screen.displayMessageLine("\nBalance Information:");
        screen.displayMessage(" - Available balance: ");
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n - Total balance:    ");
        screen.displayDollarAmount(totalBalance);
        screen.displayMessageLine("");

    }
}
