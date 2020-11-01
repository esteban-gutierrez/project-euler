package com.estebangm.euler.aux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuxiliaryOperations {
    public static List<Long> getPrimeNumbers(long start, long end) {
        List<Long> primeNumbersList = new ArrayList<>();
        if (start >= 0 && end > start) {
            for (long i = start; i <= end; i++) {
                if (isPrime(i)) {
                    primeNumbersList.add(i);
                }
            }
        }
        return primeNumbersList;
    }

    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Long> getDividersOf(long number) {
        List<Long> dividers = new ArrayList<>();
        for (long i = 1; i <= number; i++) {
            if (number % i == 0) {
                dividers.add(i);
            }
        }
        return dividers;
    }

    public static List<Long> getPrimeDividersOf(long number) {
        List<Long> primeDividers = new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0 && isPrime(i)) {
                primeDividers.add(i);
            }
        }
        return primeDividers;
    }

    public static boolean isPalindrome(long number) {
        String numberString = String.valueOf(number);
        int numberOfDigits = numberString.length();
        for (int i = 0; i < numberOfDigits / 2; i++) {
            if (numberString.charAt(i) != numberString.charAt(numberOfDigits - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
