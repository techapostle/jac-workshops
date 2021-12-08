

package Task1;

public class MyInteger {
    private final int value;

    public MyInteger() {
        this.value = 0;
    }

    public MyInteger(int usrInput) {
        this.value = usrInput;
    }

    public int getValue() {
        return this.value;
    }

    boolean isEven() {
        return isEven(this.getValue());
    }

    public boolean isOdd() {
        return isOdd(this.getValue());
    }

    public boolean isPrime() {
        return isPrime(this.getValue());
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++)
            if (number % i == 0)
                return false;
        return true;
    }

    public static int parseInt(char[] charArr) {
        System.out.println("charArr has been converted.");
        return Integer.parseInt(String.valueOf(charArr));
    }

    public static int parseInt(String myStr) {
        System.out.println("myStr has been converted.");
        return Integer.parseInt(myStr);
    }
}
