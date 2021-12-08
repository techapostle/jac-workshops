

package Task2;

import java.util.Scanner;

public class DateClient {
    static int monthInt, day, year;
    static String monthStr;
    static Date date;

    public static void main(String[] args) {
        Scanner scanOption;
        boolean keepGoing;
        do {
            System.out.println("Enter 1 for format: MM/DD/YYYY");
            System.out.println("Enter 2 for format: Month DD, YYYY");
            System.out.println("Enter 3 for format: DD YYYY");
            System.out.println("Enter 4 to exit");
            System.out.print("Choice: ");
            scanOption = new Scanner(System.in);
            int option = scanOption.nextInt();
            keepGoing = true;
            switch (option) {
                case 1:
                    setDate(monthInt, day, year);
                    break;
                case 2:
                    setDate(monthStr, day, year);
                    break;
                case 3:
                    setDate(day, year);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
            if (option != 4) {
                System.out.println("MM/DD/YYYY: " + date.genNumberFormat());
                System.out.println("Month DD, YYYY: " + date.genStringFormat());
                System.out.println("DDD YYYY: " + date.genDayFormat());
            } else {
                System.out.println("\nExiting...goodbye!");
                keepGoing = false;
            }
        } while(keepGoing);
    }

    public static void setDate(int m, int d, int y) {
        System.out.println("Enter Month (1-12): ");
        Scanner scanMonthInt = new Scanner(System.in);
        m = scanMonthInt.nextInt();
        System.out.println("Enter Day of Month: ");
        Scanner scanDay = new Scanner(System.in);
        d = scanDay.nextInt();
        System.out.println("Enter Year: ");
        Scanner scanYear = new Scanner(System.in);
        y = scanYear.nextInt();
        date = new Date(m, d, y);
    }

    public static void setDate(String m, int d, int y) {
        System.out.println("Enter Month (ex. January): ");
        Scanner scanMonthStr = new Scanner(System.in);
        m = scanMonthStr.next();
        System.out.println("Enter Day of Month: ");
        Scanner scanDay = new Scanner(System.in);
        d = scanDay.nextInt();
        System.out.println("Enter Year: ");
        Scanner scanYear = new Scanner(System.in);
        y = scanYear.nextInt();
        date = new Date(m, d, y);
    }

    public static void setDate(int d, int y) {
        System.out.println("Enter Day: ");
        Scanner scanDay = new Scanner(System.in);
        d = scanDay.nextInt();
        System.out.println("Enter Year: ");
        Scanner scanYear = new Scanner(System.in);
        y = scanYear.nextInt();
        date = new Date(d, y);
    }
}
