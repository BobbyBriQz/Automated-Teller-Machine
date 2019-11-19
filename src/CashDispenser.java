/**
 * This class handles the cash dispensing part of the ATM.
 * It has methods to check if sufficient cash is available in the dispenser and
 * to dispense cash.
 *
 * @author Bobby Utulu
 * @since 17-11-2013
 */
public class CashDispenser {

    private final static int INITIAL_COUNT = 500;
    int count;

    public CashDispenser(){
        count = INITIAL_COUNT;
    }

    /**
     * Method that handles deduction of count of available $20 bills
     * @param amount
     */
    public void dispenseCash( int amount){
        int billsRequired = amount/20;
        count -= billsRequired;
    }

    /**
     * Method that checks if there is sufficient cash to dispense withdrawal amount
     * @param amount
     * @return
     */
    public boolean isSufficientCashAvailable( int amount){

        int billsRequired = amount/20;

        if(count >= billsRequired)
            return true;
        else
            return false;
    }
}
