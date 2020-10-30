package com.estebangm.euler;

/**
 * ID 6
 *
 * The sum of the squares of the first ten natural numbers is:
 *      1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is:
 *      (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers
 * and the square of the sum is:
 *      3025 - 385 = 2640
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers
 * and the square of the sum.
 *
 * ANSWER: 25502500 - 338350 = 25164150
 */
public class SumSquareDifference {
    public static final int LIMIT = 100;

    public static void main (String [] args) {
        System.out.println(getSquareOfSumUntilLimit(LIMIT));
        System.out.println(getSumOfSquaresUntilLimit(LIMIT));
        long difference = getSquareOfSumUntilLimit(LIMIT) - getSumOfSquaresUntilLimit(LIMIT);
        System.out.println(difference);
    }

    private static long getSumOfSquaresUntilLimit(int limit) {
        long sumOfSquares = 0;
        for (int i = 1; i <= limit; i++) {
            sumOfSquares += i * i;
        }
        return sumOfSquares;
    }

    private static long getSquareOfSumUntilLimit(int limit) {
        long squareOfSum = 0;
        for (int i = 1; i <= limit; i++) {
            squareOfSum += i;
        }
        return (squareOfSum * squareOfSum);
    }
}
