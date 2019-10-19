import com.company.SavingsAccount;

public class testSavingsAccount {

    public static void main (String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(4);

        System.out.println("Calculating next years interest rate...");
        for (int i = 0; i < 12; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        System.out.printf("Current balances\n-saver1: $%.2f\n-saver2: $%.2f\n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
        System.out.println();

        SavingsAccount.modifyInterestRate(5);

        System.out.println("Calculating next month's interest rate");
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Current balances\n-saver1: $%.2f\n-saver2: $%.2f\n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
        System.out.println();

    }
}
