public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance){
        this.savingsBalance = balance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public double calculateMonthlyInterest(){
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
        return monthlyInterest;
    }

    public static void modifyInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate;
    }
}
