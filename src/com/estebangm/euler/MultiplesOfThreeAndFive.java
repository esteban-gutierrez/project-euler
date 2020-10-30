package com.estebangm.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * ANSWER: 233168
 */
public class MultiplesOfThreeAndFive {

    public static void main (String [] args) {
        List<Integer> multiplesOf3Or5Below1000 = getMultiplesOfThreeOrFiveBelowGivenNumber(1000);
        if (multiplesOf3Or5Below1000 != null) {
            System.out.println(sumValues(multiplesOf3Or5Below1000));
        }
    }

    public static boolean isMultipleOf3(int number) {
        return number % 3 == 0;
    }

    public static boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    public static List<Integer> getMultiplesOfThreeOrFiveBelowGivenNumber(int end) {
        if (end >= 3) {
            List<Integer> multiplesOfThreeOrFive = new ArrayList<>();
            for (int i = 3; i < end; i++) {
                if (isMultipleOf3(i) || isMultipleOf5(i)) {
                    multiplesOfThreeOrFive.add(i);
                }
            }
            return multiplesOfThreeOrFive;
        } else {
            return null;
        }
    }

    public static int sumValues(List<Integer> values) {
        int sum = 0;
        if (values != null) {
            for (int value : values) {
                sum += value;
            }
        }
        return sum;
    }
}
