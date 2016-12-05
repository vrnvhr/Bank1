/** This interface defines methods for all bank accounts.
 *
 *  This interface is complete and must not be changed.
 */
public interface BankAccount extends Comparable {

   // REMEMBER: methods are public by default

   /** Find out who the owner of the bank account is.
    *  @return the owner's name
    */
   String getOwner();

   /** Find out the current balance in a bank account.
    *  @return the current balance
    */
   double getBalance();

   /** Withdraw an amount from the account, if possible, updating the
    *  balance by subtracting the amount withdrawn.  
    *  @param amount how much to withdraw, should be > 0.  If the
    *  amount is negative, withdraw nothing.  If the amount is more
    *  than what is in the bank account, then withdraw only as much as
    *  you can.  If you can't withdraw the exact amount (due to
    *  denomination issues), but have enough money in the account,
    *  then withdraw the smallest total possible that is >= amount.
    *  @return the actual amount withdrawn
    */
   double withdraw(double amount);

   /** Deposit an amount into the account, if possible, updating the
    *  balance by adding the amount deposited.
    *  @param amount how much to deposit, should be > 0.  If the
    *  amount is negative or the bank account is somehow "full", do
    *  nothing.
    *  @return true if successful, false otherwise
    */
   boolean deposit(double amount);

   // Bank accounts should be compared based on the owner name,
   // case insensitive, breaking ties with account balances.

}
