/**
 * This class holds the account details of each individually bank account.
 * It has methods to validate pin, retrieve account balances, retrieve account number
 * and process debit and credit operations.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class Account {

    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;

    public Account(int accountNumber, int pin, double availableBalance, double totalBalance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }

    /**
     * Method that validates pin
     * @param pin
     * @return boolean
     */
    public boolean validatePin( int pin){

        if(pin == this.pin)
            return true;
        else
            return false;
    }

    /**
     * Method that retrieves the available account balance
     * @return availableBalance
     */
    public double getAvailableBalance(){

        return availableBalance;
    }

    /**
     * Method that retrieves the total account balance
     * @return totalBalance
     */
    public double getTotalBalance(){

        return totalBalance;
    }

    /**
     * Method that retrieves the account number
     * @return accountNumber
     */
    public int getAccountNumber(){
        return accountNumber;
    }

    /**
     * Method that handles credit operation
     * @param amount
     */
    public void credit(double amount){

        totalBalance += amount;
    }

    /**
     * Method that handles debit operation
     * @param amount
     */
    public void debit(double amount){

        availableBalance -= amount;
        totalBalance -= amount;
    }
}
