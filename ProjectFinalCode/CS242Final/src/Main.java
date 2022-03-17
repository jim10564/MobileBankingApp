import java.util.*;
/**
 * Driver Class
 * @date 12/14/2020
 * @author Jim Spisto
 * @version 1
 * Represents a mobile banking application
 */
public class Main {
    int count = 1;
    LinkedList<CheckingAccount> accountList = new LinkedList();
    LinkedList <InvestmentAccount> investmentAccountList = new LinkedList();
    public int getAccountListLength(){
        return accountList.size();
    }

    /**
     * Checks whether a bank account  with account number
     * that matches param (num), exists on the accountList
     * returns true if account exists, otherwise returns false
     * @param num
     * @return boolean
     */
    public boolean accountFound(int num){
        for (CheckingAccount c: accountList){
            if (c.getAccountNum()== num){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an account is an investment account, returns false if
     * Account is a checking account, or if the account is not found
     * returns true if account is an investment account
     * @param num
     * @return boolean
     */

    public boolean investmentFound(int num){
        for (InvestmentAccount i : investmentAccountList){
            if (i.getAccountNum()== num){
                return true;
            }
        }
        return false;
    }

    /**
     * Finds and returns a bank account, if it exists on the accountList
     * Otherwise, prints an error message
     * @param num
     * @return a bank account object, or null
     */

    public CheckingAccount getAccount(int num){
        if (accountFound(num)){
            for (CheckingAccount c : accountList){
                if (c.getAccountNum()== num){
                    return c;
                }
            }
        }
        System.out.println("Error Account not found");
        return null;
    }

    /**
     * Finds and returns an investment account
     * if it exists on the investment account list
     * otherwise,  returns false
     * @param num
     * @return investment account, or null
     */

    public InvestmentAccount getInvestment(int num){
        if (accountFound(num)){
            for (InvestmentAccount i : investmentAccountList){
                if (i.getAccountNum()== num){
                    return i;
                }
            }
        }
        System.out.println("Error Account not found");
        return null;
    }




    /**
     * Creates a Bank Account from User Input
     * @param in
     */
    public void openAccount(Scanner in) {
        System.out.println("Would you like to open a (C)hecking Account, or an (I)nvestment Account?");
        String userInput = in.nextLine();
        System.out.println("What is the Name on the Account?");
        String userName = in.nextLine();
        System.out.println("What is the Initial Balance of the Account?");
        int userBalance = in.nextInt();
        System.out.println(userInput);
        if (userInput.equals("C")){
            CheckingAccount userAccount = new CheckingAccount(userBalance, userName,count);
            count ++;
            accountList.add(userAccount);
            System.out.println("Account Added, your account Number is: " + userAccount.getAccountNum());
        }
        else if(userInput.equals("I")) {
            InvestmentAccount userAccount = new InvestmentAccount(userBalance, userName,count);
            count ++;
            accountList.add(userAccount);
            investmentAccountList.add(userAccount);
            System.out.println("Account Added, your account Number is: " + userAccount.getAccountNum());

        }
        else{
            System.out.println("Invalid input");
            return;
        }



    }

    /**
     * Transfers money between two accounts
     * Gets user input for accounts, and amount to transfer
     * @param in
     */

    public void makeTransfer(Scanner in) {
        CheckingAccount from;
        CheckingAccount to;
        System.out.println("Account number to transfer From");
        int fromID = in.nextInt();
        System.out.println("Account number to transfer to");
        int toID = in.nextInt();

        if (accountFound(toID) && accountFound(fromID) && toID != fromID) {
            System.out.println("Amount to Transfer");
            int temp = in.nextInt();
            if ((getAccount(fromID).getBalance()) >= temp) {
                int fromAmount = temp;
                getAccount(fromID).withdraw(fromAmount);
                getAccount(toID).deposit(fromAmount);
                System.out.println("Transfer Complete");
            }
            else {
                System.out.println("Error Insufficient Balance");
            }
        }
        else {
            System.out.println("Error Invalid Account(s)");
        }

    }

    /**
     * Users can Deposist or Withdraw Money from an account
     * @param in
     */
    public void manageBankacct(Scanner in){
       System.out.println("(D)eposit or (W)ithdraw?");
       String userAnswer = in.nextLine();
       System.out.println("Amount?");
       int amount = in.nextInt();
        System.out.println("Enter account Numbner");
        int ID = in.nextInt();
       getAccount(ID).manageAccount(userAnswer, amount);

    }

    /**
     * Calculates future earnings on an investment account
     * @param in
     */

    public void calculateYield(Scanner in){
        System.out.println("Enter account number");
        int accountNum = in.nextInt();
        if (investmentFound(accountNum)) {
            System.out.println("Enter year");
            int userYear = in.nextInt();
            getInvestment(accountNum).calculateEarning(userYear);
        }

        else if (accountFound(accountNum)){
            System.out.println("The account you entered is a Checking Account, you must enter an Investment Account");
        }
        else{
            System.out.println("Error, account not found");
        }

    }

    /**
     * Prints all statement balances on the accountList
     * @param in
     */

    public void printAccounts(Scanner in) {
        for (CheckingAccount c : accountList) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner in = new Scanner(System.in);
        boolean done = false;
        System.out.println("Welcome to Data Structures National Bank.");
        while (!done) {

        System.out.println("Would you like to...");
        System.out.println("(O)pen an account, Make a (T)ransfer, (V)iew balances, (C)alculate yield, (M)anage Accounts, (Q)uit");
        String userAnswer = in.next();

            if (userAnswer.equals("O")) {
                m.openAccount(new Scanner(System.in));
            }
            if (userAnswer.equals("V")){
                m.printAccounts(new Scanner(System.in));
            }
            if (userAnswer.equals("T")){
                m.makeTransfer(new Scanner(System.in));
            }
            if (userAnswer.equals("C")){
                m.calculateYield(new Scanner(System.in));
            }
            if (userAnswer.equals("M")){
                m.manageBankacct(new Scanner(System.in));
            }



        done = userAnswer.equals("Q");
        }

        System.out.println("GoodBye");

    }
}
