

package Task1;

import java.util.*;

public class MyIntegerMain {
    public static void main(String[] args) {
        System.out.println("Testing either isEven(), isOdd(), isPrime()...");
        System.out.print("Enter a number: ");
        int usrInput = new Scanner(System.in).nextInt();
        MyInteger myInteger = new MyInteger(usrInput);
        if (myInteger.isEven())
            System.out.println("Number is even.");
        if (myInteger.isOdd())
            System.out.println("Number is odd.");
        if (myInteger.isPrime())
            System.out.println("Number is prime.");

        System.out.println("Testing parseInt(char[]) and parseInt(String)...");
        char[] myChars = {'1', '2', '3', '4'};
        String myStr = "1234";
        int convertedChars = MyInteger.parseInt(myChars);
        int convertedStr = MyInteger.parseInt(myStr);
        System.out.println("myChars: " + convertedChars);
        System.out.println("myStr: " + convertedStr);
        int addedChars = convertedChars + 1;
        int addedStrs = convertedStr + 1;
        System.out.println("myChars + 1 = " + addedChars);
        System.out.println("myStr + 1 = " + addedStrs);
    }
}
