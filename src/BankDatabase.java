/**
 * This class serves as the Bank's database. It has methods that
 * handles account retrieval, user authentification,
 * account balance retrieval and a few other operations.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class BankDatabase {

    private Account[] accounts;

    public BankDatabase(){
        accounts = new Account[2];
        accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
        accounts[1] = new Account(98765, 56789, 200.0, 200.0);
    }

    /**
     * Method that gets account associated with an account number passed as a parameter,
     * from the accounts array.
     * @param accountNumber
     * @return currentAccount or null.
     */
    private Account getAccount(int accountNumber){
        for (Account currentAccount : accounts){
            if(currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }
        return null;
    }

    /**
     * Method that checks whether account details exists in the bank database.
     * @param userAccountNumber
     * @param userPin
     * @return
     */
    public boolean authenticateUser(int userAccountNumber, int userPin){

        Account userAccount = getAccount(userAccountNumber);
        if (userAccount != null)
            return userAccount.validatePin(userPin);
        else
            return false;
    }

    /**
     * Method that retrieves available balance of a user's account
     * @param userAccountNumber
     * @return availableBalance
     */
    public double getAvailableBalance(int userAccountNumber){

        return getAccount(userAccountNumber).getAvailableBalance();
    }

    /**
     * Method that retrieves total balance of a user's account
     * @param userAccountNumber
     * @return totalBalance
     */
    public double getTotalBalance(int userAccountNumber){

        return getAccount(userAccountNumber).getTotalBalance();
    }

    /**
     * Method that credits the account of the passed in account number with the amount passed.
     * @param userAccountNumber
     * @param amount
     */
    public void credit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).credit(amount);
    }

    /**
     * Method that debits the account of the passed in account number with the amount passed.
     * @param userAccountNumber
     * @param amount
     */
    public void debit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).debit(amount);
    }
}
