/**********************************************
 Workshop 7
 Course: JAC444 - Semester
 Last Name: Dadkhah Shokrollahi
 First Name: Kian
 ID: 119369205
 Section: NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2021-11-18
 **********************************************/

package ca.jac444.ws6.task1;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;

public class LoanCompare extends JFrame {
    private double amount, interest;
    private JTextField carPriceInput, downPaymentInput, interestInput;
    private final double[] monthly;
    private final int[] months = {24, 36, 48, 60};

    LoanCompare() {
        super("Loan Calculator");
        monthly = new double[months.length];
        LoanCompareApp();
    }

    private void LoanCompareApp() {
        setLayout(new FlowLayout());
        carPriceInput = new JTextField(6);
        downPaymentInput = new JTextField(6);
        interestInput = new JTextField(6);
        JButton submitButton = new JButton("Submit");
        add(new JLabel("Enter 1: car price, 2: down-payment, 3: interest (%)"));
        add(carPriceInput);
        add(downPaymentInput);
        add(interestInput);
        add(submitButton);

        submitButton.addActionListener(
                e -> {
                    double tempAmount;
                    double tempInterest;
                    try {
                        tempAmount = Double.parseDouble(carPriceInput.getText()) - Double.parseDouble(downPaymentInput.getText());
                        tempInterest = Double.parseDouble(interestInput.getText());
                        if (tempAmount > 0.0) {
                            calculateMonthly(tempAmount, tempInterest);
                            displayOptions();
                        }
                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
                }
        );
    }

    void calculateMonthly(double tempAmount, double tempInterest) {
        this.amount = tempAmount;
        this.interest = (tempInterest / 100) / 12;
        for (int i = 0; i < months.length; i++) {
            monthly[i] = amount / ((Math.pow((interest + 1), months[i]) - 1) / (interest * Math.pow((interest + 1), months[i])));
        }
    }

    void displayOptions() {
        LoanOptions options = new LoanOptions();
    }

    class LoanOptions extends JFrame {
        public LoanOptions() {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(650, 900);
            setVisible(true);
            setLayout(new FlowLayout());
            int option = 0;
            for (int i = 0; i < months.length; i++) {
                add(new JLabel("Payment option - " + ++option));
                add(new JLabel("Monthly amount: $" + String.format("%.2f", monthly[i]) + ", for " + months[i] + " months.\n"));
            }
        }
    }
}