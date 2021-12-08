package task2;

/**
 * * This class initializes member userNumber of type Integer,
 * and checks if its given value is a prime number or not.
 * If the userNumber is a prime number, the class allows the
 * program to notify that it is prime.
 * Else if userNumber is not prime, the class enables the program
 * to calculate and return a list of userNumber's prime factors.
 */
public class CheckPrimeFactors {
    public int userNumber;

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
        while (number % 2 == 0) {
            returnStr += (2 + " ");
            number /= 2;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                returnStr += (i + " ");
                number /= i;
            }
        }
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

//    public static void main(String[] args) {
//        System.out.println("Enter a number to check for prime status.");
//        System.out.print("Number: ");
//        int inputNum = new Scanner(System.in).nextInt();
//
//        // create new CheckPrimeFactors obj
//        CheckPrimeFactors myObj = new CheckPrimeFactors(inputNum);
//        myObj.display();
//    }
}