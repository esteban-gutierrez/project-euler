package com.estebangm.euler.aux;

import java.util.ArrayList;
import java.util.List;

public class AuxiliaryOperations {

    public static Integer[] getPrimeNumbers(int start, int end) {
        if (start >= 0 && end > start) {
            List<Integer> primeNumbersList = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    primeNumbersList.add(i);
                }
            }
            return (Integer []) primeNumbersList.toArray();
        } else {
            return null;
        }
    }

    public static boolean isPrime(int number) {
        if (number > 0) {
            return (findFirstDivider(number) == number);
        }
        return false;
    }

    private static int findFirstDivider(int number) {
        int firstDivider = 1;
        if (number > 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    firstDivider = i;
                    break;
                }
            }
        }
        return firstDivider;
    }
}
