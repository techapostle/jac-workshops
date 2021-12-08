package task1;

import java.lang.Math;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class RandomNumList {
    /**
     * This program generates a list of 25 random numbers from 0 to 100.
     * It will display the numbers. Then it will calculate the sum and average
     * of all generated numbers and display them.
     */
    public LinkedList<Integer> listOfRandom;

    RandomNumList() {
        listOfRandom = new LinkedList<Integer>();
        for (int i = 0; i < 25; i++) listOfRandom.add((int)(Math.random() * 100));
        Collections.sort(listOfRandom);
    };

    public static void main(String[] args) {
        RandomNumList numList = new RandomNumList();
        int sum = 0;
        int listSize = numList.listOfRandom.size();

        System.out.println("Outputting sorted list of random numbers from 0 to 100...");
        for (int i = 0; i < listSize; i++)
            System.out.print(numList.listOfRandom.get(i) + " ");

        System.out.println("\n\nCalculating the sum of random numbers...");
        for (int i = 0; i < listSize; i++)
            sum += numList.listOfRandom.get(i);
        System.out.println("Sum: " + sum);

        System.out.println("\nCalculating the average of random numbers...");
        System.out.println("Average: " + (double)(sum) / listSize);
    }
}