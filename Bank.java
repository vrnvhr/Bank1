import java.util.Arrays;
/** This class represents a bank that contains bank accounts.  As a
 *  general collection of items, it implements the Database interface.
 *  Once a Bank is created with a particular capacity, it can only
 *  hold that many different bank accounts.  
 *
 *  Each Bank has a name, a collection of accounts, and a current 
 *  number of bank accounts in it.
 * 
 *  See HW10.java for a main driver program that uses this class.
 */
public class Bank implements Database {

   /* name of account holder */
   private String name;
   /* size of array*/
   private int len;
   /* name */
   private static int numAcc = 0;
   /* name */
   private BasicAccount bank1 [];

   /** Create a Bank with room to hold the default Database STARTSIZE
    *  number of BankAcount items.
    *  @param nm the name of the bank
    */
   public Bank(String nm) {
   
      
      bank1 = new BasicAccount[STARTSIZE];
      this.name = nm;
      this.len = STARTSIZE;
   
   }

   /** Create a Bank with room to hold the request number of
    *  BankAccount items.
    *  @param nm the name of the bank
    *  @param cap the requested capacity of the Bank
    */
   public Bank(String nm, int cap) {
   
      
      this.name = nm;
      this.len = cap;
      bank1 = new BasicAccount[cap];  
   }
   
   /** Find out how many things are in the database.
       @return the number
   */

   public int size() {
   
      return this.numAcc;
   }
   
   /** Converts object to string.
   @param o object to be passed
   */

   public String toString(Object O){
         String s = "";
         s = "Name: " + name + "   # of Accounts: " + this.size();
         return s; 
   }
   
     /** Display the items in the database on the screen, one per line.
   */

   public void display() {
   if(numAcc > 0) {
      for(int i = 0; i < numAcc; i++){
         System.out.println("Name: " + bank1[i].getOwner() +
          "  Balance: $" + bank1[i].getBalance());
         }
        }
    else {System.out.println("No Accounts to Display");
          }
        }
   
   
   public Object find(Object o){ 
   if( o == null) 
      return null;
      if(o instanceof BasicAccount){
         BasicAccount b = (BasicAccount) o;
         if(numAcc == 0) {
            return null;
            }
         for (int i = 0; i < numAcc; i++){
            if (bank1[i].equals(b)){
               return bank1[i];
            }
           return null;
         }
      }
      return null;
   }
    /** Add an item to the database, if there is room and it is not
       already there, updating the size accordingly.
       @param o the object to add
       @return true if added, false otherwise
   */
   public boolean add(Comparable o){ 
   if(o instanceof BasicAccount){
   BasicAccount a = (BasicAccount) o;
   if(numAcc < len && find(o) == null){
      bank1[numAcc] = a;
      numAcc++;
      System.out.println(numAcc);
      return true;
      }
      return false;
     }
     return false;
    }
               
            
   
   public Object delete(Object o){
      int i = 0;
      BankAccount a = null;
      if(find(o) != null) {
        i = Arrays.binarySearch(bank1 ,find(o));
        a = (BasicAccount)find(o);
        bank1[i] = null;
         for(int b = i; b < len; b++) {
            if(!(i == len - 1)){
            bank1[i] = bank1[i+1];
            }
           }
        numAcc -= 1;
         }
       return a;
       }
             
      
   public void sort(){
      for(int j = 0; j < numAcc; j++){
      for(int i = 0; i < numAcc - 1; i++){
       if((bank1[i].getOwner()).compareTo((bank1[i + 1].getOwner())) == 1){
         BasicAccount temp = bank1[i + 1];
         bank1[i + 1] = bank1[i];
         bank1[i] = temp;
         }
        }
      
      

   /* Override the toString method so that it returns the bank name
      and current (actual) number of BankAccount items, like this:
          Name: Joanne Federal Bank    # of Accounts: 203
   */

}

}

}
