public class InvestmentAccount extends CheckingAccount{

    /**
     * Constructs an Investment Account with an initial balance
     * and name on  the account
     * @param startVal
     * @param name
     * @param ID
     */
    public InvestmentAccount(int startVal, String name, int ID) {
        super(startVal, name, ID);
    }

    /**
     * Prints relevant Investment Account Information
     * @return String
     */

    @Override
    public String toString() {
        return "S&P 500 Investment Account, " + super.toString();
    }

    /**
     * Calculates future earnings based on user input
     * @param userYear, future year used in calculations
     */
    public void calculateEarning(int userYear){
        double difference = userYear - 2020;
        double principal = this.getBalance();
        int newBalance = (int) (principal * Math.pow(1.07, difference));
        System.out.println("At a 7% interest rate, In " + (int)difference+ " years you will have " + "$" + newBalance);

    }
}
