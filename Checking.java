/** This is a basic banking account with the addition of checking
 *  features.  A checking account uses sequential check numbers each
 *  time a check is written, starting at number 1 by default.
 *
 *  Each Checking object has the data inherited from BasicAccount,
 *  and also a data member that keeps track of the next check 
 *  number to use.
 */
public class Checking extends BasicAccount {

   // add a data member to keep track of the current check number
   private int check;
 
   /** Initialize a checking account with the owner's name, a
    *  starting balance, and a starting check number of 1.
    *  @param nm the owner's name
    *  @param bal the starting balance, must be > 0
    */
   public Checking(String nm, double bal) {
      super(nm,bal);
      check = 0;
       // this will cause a compiler error until you write it and
       // properly call the constructor from the base class
   }

   /** Write a check for a given amount, withdrawing the money from
    *  the account if possible.  If the check bounces (amount is too
    *  high for the balance), then deduct a $20 check bouncing fee
    *  from the account instead, regardless of the current balance.
    *  @param amount the amount of the check, should be > 0.  If the
    *  the amount <= 0, then do nothing.
    *  @return the check number used (they advance sequentially), or 0
    *  if the operation failed.
    */
   public int writeCheck(double amount) {
     if (amount <= 0){ 
      return check;
      }
     if (initial - amount < 0) {
        initial -= 20;
        check++;
        return check;
        }
     else{
      initial -= amount;
      check++;
      return check;
      }
     }
    
     
    public String toString(){
      String s = "Name: " + name1 + "    Balance:" + initial + "   Next" +
      " Check #: " + (check + 1);

      return s;
    }

   /*
   Override the toString method so that it includes the name, balance
   and next check number, using exactly this format:
         Name: Jack Sparrow   Balance: $1024.00   Next Check #: 22
   */

}
