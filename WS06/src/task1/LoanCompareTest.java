package task1;

public class LoanCompareTest {
    public static void main(String[] args) {
        double carPayment = 39998.98;
        double downPayment = 14000.00;
        double loanAmount = carPayment - downPayment;
        double interestAmount = 6.6;
        // TODO: User input
        LoanCompare loanOptions = new LoanCompare(loanAmount, interestAmount);
        loanOptions.calculateMonthly();
        loanOptions.display();
    }
}