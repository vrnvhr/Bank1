import java.util.Scanner;

/** Test driver program for homework #10 - Banking.
 */
public class HW10 {

    /** The Scanner to read from the keyboard. */
   private static Scanner kb = new Scanner(System.in);

    /** Main method for execution of test and user-based methods.
     *  @param args not used.
     */
   public static void main(String[] args) {
   
        // you can use one or both of these to test,
        // just comment out whichever you don't want to run
   
     test();
      //          user();
   
   }

    /** Create a bunch of objects and do little tests on them.
     */
   public static void test() {
      BasicAccount b1 = new BasicAccount("Harry", 20);
      testBA(b1, "Harry", 20);
      b1.deposit(20);
      BasicAccount b2 = new BasicAccount("Mary", 20);
      testBA(b2, "Mary", 20);
      b2.deposit(20);
   
      Checking c1 = new Checking("Mickey Mouse", 200);
      testBA(c1, "Mickey Mouse", 200);
      c1.deposit(200);
      Checking c2 = new Checking("Donald Duck", 104.23);
      testBA(c2, "Donald Duck", 104.23);
      c2.deposit(104.23);
   
      Savings s1 = new Savings("Penelope Cruz", 2000, .045);
      testBA(s1, "Penelope Cruz", 2000);
      s1.deposit(2000);
      Savings s2 = new Savings("Maya Something", 15200, .03);
      testBA(s2, "Maya Something", 15200);
      s2.deposit(15200);
   
      System.out.println("b1 < b2 ? " + (b1.compareTo(b2) < 0) + " should be true");
      System.out.println("b1 < c2 ? " +  (b1.compareTo(c2) < 0) + " should be true");
      System.out.println("s1 same s1 ? " + (s1.compareTo(s1) == 0) + " should be true");
      System.out.println("s1 same s1 ? " + (s1.equals(s1) == true) + " should be true");
   
      int cnum;
      double rate;
      double bal;
      double amt, actual;
   
   
        // Checking specific tests
      System.out.println("\n Checking tests --------------- ");
      System.out.println("c1 is: " + c1);
      amt = 50;
      cnum = c1.writeCheck(amt);
      System.out.println("after writing check for " + amt
                           + " c1 balance is " + c1.getBalance()
                           + " (should be 150)");
      System.out.println("check num was " + cnum + " (should be 1)");
      amt = c1.getBalance() + 10;
      cnum = c1.writeCheck(amt);
      System.out.println("after writing check for " + amt
                           + " c1 balance is " + c1.getBalance()
                           + " (should be 130)");
      System.out.println("check num was " + cnum + " (should be 0)");
   
      amt = -100;
      cnum = c1.writeCheck(amt);
      System.out.println("after writing check for " + amt
                           + " c1 balance is " + c1.getBalance()
                           + " (should be 130)");
      System.out.println("check num was " + cnum + " (should be 0)");
   
      amt = 30;
      cnum = c1.writeCheck(amt);
      System.out.println("after writing check for " + amt
                           + " c1 balance is " + c1.getBalance()
                           + " (should be 100)");
      System.out.println("check num was " + cnum + " (should be 2)");
      System.out.println("c1 is now " + c1);
      System.out.println();
        
   
        // Savings specific tests
        
      System.out.println("\n Savings tests --------------- ");
      System.out.println("s1 is " + s1);
      System.out.println("s2 is " + s2);
   
      bal = s1.getBalance();
      amt = bal * s1.getRate();
      System.out.println("added interest for s1 should be " + amt + " and is "
                           + s1.compoundInterest());
      System.out.println("after compound, s1 has " + s1.getBalance()
                           + " (should be " + (bal + amt) + ")");

      bal = s2.getBalance();
      amt = bal * s2.getRate();
      System.out.println("added interest for s2 should be " + amt + " and is "
                           + s2.compoundInterest());
      System.out.println("after compound, s2 has " + s2.getBalance()
                           + " (should be " + (bal + amt) + ")");

      System.out.println("s1 rate is: " + s1.getRate() + " (should be 0.045)");
      System.out.println("s2 rate is: " + s2.getRate() + " (should be 0.03)");

      s1.changeRate(.10);
      System.out.println("after change s1 rate is: " + s1.getRate() + " (should be 0.1)");
      bal = s1.getBalance();
      amt = bal * s1.getRate();
      System.out.println("added interest for s1 should be " + amt + " and is "
                           + s1.compoundInterest());
      System.out.println("after compound, s1 has " + s1.getBalance()
                           + " (should be " + (bal + amt) + ")");

      System.out.println("s1 is " + s1);
      System.out.println("s2 is " + s2);
        
   }

    /** Test the BankAccount methods.
     *  @param ba the BankAccount to be tested
     *  @param name the expected owner's name
     *  @param bal the expected balance
     */
   public static void testBA(BankAccount ba, String name, double bal) {
   
      double amt;
      System.out.println();
   
      System.out.println("name should be: " + name + " and is: "
                           + ba.getOwner());
      System.out.println("balance should be: " + bal + " and is: "
                           + ba.getBalance());
      System.out.println("string rep is: " + ba.toString());
   
      System.out.print("after 100 deposit (true) --> " + ba.deposit(100));
      bal += 100;
      System.out.println(" balance should be: " + bal + " and is: "
                           + ba.getBalance());
   
      System.out.print("after 50 withdraw (50.0) --> " + ba.withdraw(50));
      bal -= 50;
      System.out.println(" balance should be: " + bal + " and is: "
                           + ba.getBalance());
        
      System.out.print("after -100 deposit (false) --> " + ba.deposit(-100));
      System.out.println(" balance should be: " + bal + " and is: "
                           + ba.getBalance());
   
      System.out.print("after -100 withdraw (0.0) --> " + ba.withdraw(-100));
      System.out.println(" balance should be: " + bal + " and is: "
                           + ba.getBalance());
   
      System.out.println("after too big a withdraw --> ");
      amt = ba.withdraw(bal + 10);
      System.out.println("amount withdrawn should be: " + bal
                           + " and is: " + amt);
      bal = 0;
      System.out.println("balance should be: " + bal + " and is: "
                           + ba.getBalance());
   
      System.out.println();
   }


    /** Let the user manipulate the Bank and BankAccounts.
     */
   public static void user() {
   
      Bank bank = new Bank("The Bank Bank", 10);
      BankAccount account;
      Object obj;
   
      char choice;
      do {
         choice = menu();
         switch (choice) {
            case 'g':
               System.out.println("bank has " + bank.size() + " accounts");
               break;
            case 'f':
               account = getAccount();
               obj = bank.find(account);
               if (obj != null) {
                  System.out.println("found it: " + obj);
               } 
               else {
                  System.out.println("not found");
               }
               break;
            case 'd':
               System.out.println("Displaying " + bank);
               bank.display();
               break;
            case 'a':
               addAccount(bank);
               break;
            case 'r':
               account = getAccount();
               obj = bank.delete(account);
               if (obj != null) {
                  System.out.println("delete it: " + obj);
               } 
               else {
                  System.out.println("not found, not deleted");
               }
               break;
            case 's':
               bank.sort();
               System.out.println("accounts after sorting: ");
               bank.display();
               break;
            case 'q':
               break;
            default:
               System.err.println("ERROR: invalid choice, try again");
         }
      } while (choice != 'q');
   }

    /** Present a menu and get a choice from the user.
     *  @return the user's choice
     */
   public static char menu() {
      System.out.print("Choose from (g)et size, (f)ind account, "
                           + " (d)isplay all accounts, (a)dd account,"
                           + " (r)emove acount, (s)ort accounts, (q)uit: ");
      return kb.nextLine().toLowerCase().charAt(0);
   }

    /** Get an account name and balance from the user.
     *  @return a BankAccount with those details
     */
   public static BankAccount getAccount() {
      String name;
      double bal;
      System.out.print("enter account owner's name: ");
      name = kb.nextLine();
      System.out.print("enter account balance: ");
      bal = Double.parseDouble(kb.nextLine());
      return new BasicAccount(name, bal);
   }

    /** Get subtype and data for a new account and add to the bank.
     *  @param b the bank we're adding the new account to
     */
   public static void addAccount(Bank b) {
      BankAccount temp;
      System.out.println("Choose from (b)asic, (c)hecking, or (s)avings: ");
      char choice = kb.nextLine().toLowerCase().charAt(0);
      temp = getAccount();
      switch (choice) {
         case 'b':
            b.add(new BasicAccount(temp.getOwner(), temp.getBalance()));
            break;
         case 'c':
            b.add(new Checking(temp.getOwner(), temp.getBalance()));
            break;
         case 's':
            System.out.println("enter interest rate (between 0 and 1): ");
            double rate = Double.parseDouble(kb.nextLine());
            b.add(new Savings(temp.getOwner(), temp.getBalance(), rate));
            break;
         default:
            System.err.println("sorry - invalid account type");
      }
   }
  

}
