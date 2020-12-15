public class CheckingAccount {
    private int balance, accountNum;
    private String nameOnAcct;
    Main m = new Main();

    /**
     * Constructs a Checking Account with an initial balance
     * and name on account
     */
    public CheckingAccount(int startVal,String name, int ID){
        this.balance = startVal;
        this.nameOnAcct = name;
        this.accountNum = ID;
    }
    /**
     * Gets the current balance of the checking account
     * @return int balance
     */

    public int getAccountNum() {
        return accountNum;
    }

    /**
     * Deposits or Withdraws from an account
     * @param userAnswer, user chooses action
     * @param amount, amount to withdraw/deposit
     */

    public void manageAccount(String userAnswer, int amount){
        if (userAnswer.equals("D")){
            this.deposit(amount);
            System.out.println("$" + amount + " has been deposited into your account");
        }
        else if (userAnswer.equals("W")){
            if(this.getBalance()>= amount){
            this.withdraw(amount);
            System.out.println("$" + amount + " has been Withdrawn into your account");
            }
            else{
                System.out.println("Error, Insufficient Funds");
            }
        }
        else{
            System.out.println("Invalid input");
        }

    }

    /**
     * Gets the current balance of the account
     * @return balance
     */

    public int getBalance() {
        return balance;
    }

    /**
     * Gets the name associated with the checking account
     * @return String nameOnAcct
     */

    public String getNameOnAcct() {
        return nameOnAcct;
    }

    /**
     * Deposits money into checking account
     * @param amount, the amount to be added
     */
    public void deposit(int amount){
        balance += amount;
    }
    /**
     * Withdraws money from checking account
     * @param amount, amount to be withdrawn;
     */
    public void withdraw(int amount){
        balance -= amount;
    }

    /**
     * Prints relevant Checking account information
     * @return String
     */

    @Override
    public String toString() {
        return "Account Number " + getAccountNum()+"," + " Name on account: " + getNameOnAcct()+"," +
        " Balance: $" + getBalance();
    }
}
