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

package task2;

import java.util.Scanner;

public class ArrayProcessorClass {
    /**
     * The following static members are defined via lambda expressions.
     * The members contained in this class contain a value for a given array:
     * maximum value,
     * minimum value,
     * sum of all values,
     * average of all values in the array
     */

    // maximum
    public static final ArrayProcessor calculateMax = array -> {
        double max = array[0];
        for (double i : array) {
            if (i > max) max = i;
        }
        return max;
    };

    // minimum
    public static final ArrayProcessor calculateMin = array -> {
        double min = array[0];
        for (double i : array) {
            if (i < min) min = i;
        }
        return min;
    };

    // sum
    public static final ArrayProcessor calculateSum = array -> {
        double total = 0;
        for (double v : array)
            total += v;
        return total;
    };

    // average
    public static final ArrayProcessor calculateAvg = array -> calculateSum.operations(array) / array.length; // implicit return gang

    /**
     * This function returns an ArrayProcessor that counts
     * the number of times a certain value occurs in an array.
     */
    public static ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (double i : array) {
                if (i == value) count++;
            }
            return count;
        };
    }

    // main method
    public static void main(String[] args) {
        // Create array based on user input
        System.out.print("Enter the desired number of elements to be processed: ");
        int numElements = new Scanner(System.in).nextInt();
        double[] userArray = new double[numElements];
        for (int i = 0; i < numElements; i++) {
           System.out.print("Element " + (i + 1) + ": ");
           userArray[i] = new Scanner(System.in).nextDouble();
        }

        // test operations
        System.out.println("\nSum of all elements: " + calculateSum.operations(userArray));
        System.out.println("Average of all elements: " + calculateAvg.operations(userArray));
        System.out.println("Minimum value in array: " + calculateMin.operations(userArray));
        System.out.println("Maximum value in array: " + calculateMax.operations(userArray));

        System.out.println("\nNow testing the count function...");
        System.out.println("This will count the number of occurances for a given double in the array");
        System.out.println("Enter a valid double from the array to count.");
        System.out.print("value: ");
        double countThis = new Scanner(System.in).nextDouble();

        System.out.println("The double " + countThis + " was counted " + counter(countThis).operations(userArray) + " times.");
    }


}