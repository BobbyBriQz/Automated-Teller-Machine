/**
 * This class is an abstract class representing transactions to be carried out on the ATM,
 * It has methods to retrieve account number, get reference to the screen and Bank database.
 * It also has an abstract execute method that must be implemented by all it's subclasses.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public abstract class Transaction {

    private int accountNumber;
    private Screen screen;
    private BankDatabase bankDatabase;

    public Transaction(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase){
        accountNumber = userAccountNumber;
        screen = atmScreen;
        bankDatabase = atmBankDatabase;
    }

    public int getAccountNumber(){

        return accountNumber;
    }

    public Screen getScreen(){
        return screen;
    }

    public BankDatabase getBankDatabase(){
        return bankDatabase;
    }

    public abstract void execute();
}
