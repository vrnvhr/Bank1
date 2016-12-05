/** This class represents savings accounts objects.  In addition to
 *  BasicAccount features, each Savings account has an interest rate
 *  that can be changed, and a method to compound interest based on
 *  the rate.  
 *
 *  Each Savings object has the data inherited from BasicAccount,
 *  and also a data member that keeps track of the interest rate. 
 */
public class Savings extends BasicAccount {   // Start by writing the rest of the class declaration.

   private double interest;
   
   // Don't forget to add the extra data member(s).


   /** Initialize a Savings account with the owner's name, a
    *  starting balance, and the given interest rate.
    *  @param nm the owner's name
    *  @param bal the starting balance, must be > 0
    *  @param intRate the interest rate, must be between 0 and 1
    */
   public Savings(String nm, double bal, double intRate) {
      super(nm, bal);
      interest = intRate;
      
       // this will cause a compiler error until you write it and
       // properly call the constructor from the base class
   }

   /** Compound the interest as follows: multiply the interest rate by
    *  the current balance and then add it to the balance.
    *  @return the amount of interest added to the balance
    */
   public double compoundInterest() {
   double start = initial;
   initial = initial * interest + initial;
   return (initial - start);
      
   }

   /** Find out the current interest rate.
    *  @return the rate
    */
   public double getRate() {
      return this.interest;
   }

   /** Change the interest rate, assuming the new value is valid.
    *  @param intRate the new interest rate, must be between 0 and 1
    */
   public void changeRate(double intRate) {
   if (0 < intRate && 1 > intRate) {
      this.interest = intRate;
      }
   }
   
   public String toString(){
      String s = "Name: " + name1 + "    Balance:" + initial + "   Interest" +
      " Rate: " + this.interest;

      return s;
    }


   /*
   Override the toString method so that it includes the name, balance
   and interest rate, using exactly this format:
         Name: Jack Sparrow   Balance: $1024.00   Interest Rate: 2.3%
   */

}
