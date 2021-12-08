package task2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Scanner;

public class CheckPrimeFactors {
    public int userNumber;

    @FXML
    private Label factorsLabel;

    @FXML
    protected void onButtonClick() {
        factorsLabel.setText(display());
    }

    CheckPrimeFactors() {
        this(2);
    }

    CheckPrimeFactors(int inputNum) {
        userNumber = inputNum;
    }

    private boolean checkIfPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private String printPrimeFactors(int number) {
        String returnStr = "";
        // Print the number of 2s that divide number
        while (number % 2 == 0) {
            returnStr += (2 + " ");
            number /= 2;
        }
        // number must be odd at this point.  So we can skip one element (i=i+2)
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            // While i divides number, print i and divide number by i
            while (number % i == 0) {
                returnStr += (i + " ");
                number /= i;
            }
        }
        // This condition is to handle the case when number is a prime number greater than 2
        if (number > 2)
            returnStr += number;

        return returnStr;
    }

    public String display() {
        if (checkIfPrime(userNumber)) {
            return "Number " + userNumber + " is prime.";
        }
        return "Prime factors: " + printPrimeFactors(userNumber);
    }

    public static void main(String[] args) {
        // create new CheckPrimeFactors obj
        CheckPrimeFactors myObj = new CheckPrimeFactors();
    }

}