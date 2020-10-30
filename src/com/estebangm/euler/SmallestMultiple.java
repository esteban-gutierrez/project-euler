package com.estebangm.euler;

import static com.estebangm.euler.aux.AuxiliaryOperations.isPrime;

/**
 * ID 5
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * ANSWER: 232792560
 */
public class SmallestMultiple {
    public static final int LIMIT = 20;

    public static void main (String [] args) {
        for (long i = computeStartingNumber(LIMIT); ; i++) {
            if (isDivisibleByNumbersUpToLimit(i, LIMIT)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static long computeStartingNumber(int limit) {
        long startingNumber = 1;
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                startingNumber *= i;
            }
        }
        System.out.println(startingNumber);
        return startingNumber;
    }

    private static boolean isDivisibleByNumbersUpToLimit(long number, int limit) {
        for (int i = 2; i <= limit; i++) {
            if (number % i != 0) {
                return false;
            }
        }
        return true;
    }
}
