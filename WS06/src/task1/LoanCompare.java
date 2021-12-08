package task1;

public class LoanCompare {
    private final double amount, interest;
    private final double[] monthly;
    private final int[] months = {24, 36, 48, 60};

    LoanCompare() {
        this(0, 0);
    }
    LoanCompare(double a, double i) {
        this.amount = a;
        this.interest = i;
        monthly = new double[months.length];
    }

    void calculateMonthly() {
        double r = (interest / 100) / 12;
        for (int i = 0; i < months.length; i++) {
            monthly[i] = amount / ((Math.pow((r + 1), months[i]) - 1) / (r * Math.pow((r + 1), months[i])));
        }
    }

    void display() {
        int option = 0;
        for (int i = 0; i < months.length; i++) {
            System.out.println("Payment option " + ++option);
            System.out.println("Monthly amount: $" + String.format("%.2f", monthly[i]) + ", for " + months[i] + " months.\n");
        }
    }
}