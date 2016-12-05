/** This is a basic bank account, like an ATM machine.
 *
 *  Every BasicAccount contains the account owner's name
 *  and the current balance (amount of money) in the account.
 */
public class BasicAccount implements BankAccount {
   
    protected String name1;
    protected double initial;
    protected double balance;
   /** Create a BasicAccount.
    *  @param nm the name of the account owner
    *  @param start the starting balance of the account
    */
   public BasicAccount(String nm, double start) {
   this.name1 = nm;
   this.initial = start;
   }
   


  
   public String getOwner() {
      return this.name1;
   }

   
   public double getBalance() {
      return this.initial;
   }

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

   public double withdraw(double amount) {
      if (amount <= 0){ 
         return 0;
         } 
      if ((this.initial - amount) < 0){
      balance = this.initial;
      this.initial = 0;
      return balance;
         }
      else{
      this.initial -= amount;
      return amount;
      }
   }
/** Deposit an amount into the account, if possible, updating the
    *  balance by adding the amount deposited.
    *  @param amount how much to deposit, should be > 0.  If the
    *  amount is negative or the bank account is somehow "full", do
    *  nothing.
    *  @return true if successful, false otherwise
    */

   
   public boolean deposit(double amount) {
      if (amount > 0){
      this.initial += amount;
      return true;
      }
      return false;
   }

   /** Compare BasicAccounts based on their balances, breaking ties by
    *  comparing the owners' names ignoring capitalization.
    *  @param o the object to compare to this account
    *  @return negative value if this account is < o's account,
               positive value if this account is > o's account, 
               and 0 if the same according to balance and owner.
    */
   public int compareTo(Object o) {
   if(o instanceof BasicAccount) {
      
        BasicAccount b = (BasicAccount) o;
         if (getBalance() == b.getBalance()){
            if (getOwner().toLowerCase().equals(b.getOwner().toLowerCase())){
            return 0;
            }
            else if (getOwner().toLowerCase().compareTo(b.getOwner().toLowerCase()) == 1) {
            return 1;
            }
            else {
               return -1;
               }
            }
         else if (getBalance() < b.getBalance()){
            return -1;
            }
         else {
            return 1;
            } 
          }  
      return 100000000;    
    
   }
   
   public boolean equals(Object o){
   
      if (compareTo(o) == 0){
         return true;
         }
        return false;
       }
   
   public String toString(){
   String s = "Name: " + this.name1 + "    Balance:" + this.initial;
   return s;
   }

   /*
   You must also add methods to override equals and toString as follows:

   BasicAccounts are equal if they have the same balance and owner.

   Include the balance and the owner in the string description,
   formatted exactly like this:  Name: Jack Sparrow   Balance: $1024.00
   */
    
}
