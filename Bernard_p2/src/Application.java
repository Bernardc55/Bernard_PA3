public class Application {
    public static void main(String[] args) {
        //creates 2 accounts with the given starting balances
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        //modifies the interest rate to 4%
        SavingsAccount.modifyInterestRate(0.04);

        //calculates the monthly interest for both accounts, then prints them
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Current balance for the account saver1 is: %.2f \n", saver1.getSavingsBalance());
        System.out.printf("Current balance for the account saver2 is: %.2f \n", saver2.getSavingsBalance());

        //modifies the interest rate to 4%
        SavingsAccount.modifyInterestRate(0.05);

        //calculates the monthly interest for both accounts, then prints them
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Current balance for the account saver1 is: %.2f \n", saver1.getSavingsBalance());
        System.out.printf("Current balance for the account saver2 is: %.2f \n", saver2.getSavingsBalance());

    }
}
