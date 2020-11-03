package com.estebangm.euler;

import java.util.ArrayList;
import java.util.List;

import static com.estebangm.euler.aux.AuxiliaryOperations.*;

/**
 * ID 51
 *
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first
 * example having seven primes among the ten generated numbers, yielding the family:
 * 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 *
 * ANSWER: 121313
 */
public class PrimeDigitReplacements {
    public static void main (String [] args) {
        int primes;
        List<Integer> numbers;
        algorithm:
        for (int digits = 2; digits < 8; digits++) {
            for (int candidate = (int) (Math.pow(10, digits - 1)) + 1; candidate < (Math.pow(10, digits)); candidate++) {
                if (candidate % 10 != 0) {
                    for (int position = 1; position <= (Math.pow(2, digits) - 2); position++) {
                        String positionsInBinary = Integer.toBinaryString(position);
                        List<Integer> positionsToChange = getPositionsToChange(positionsInBinary.toCharArray());
                        primes = 0;
                        numbers = new ArrayList<>();
                        for (int i = 1; i < 10; i++) {
                            int changed = changeNumberWithDigitInPositions(candidate, i, positionsToChange);
                            if (isPrime(changed)) {
                                primes++;
                                numbers.add(changed);
                            }
                        }
                        if (primes >= 8) {
                            System.out.println(numbers);
                            System.out.println("positions changed: " + positionsToChange);
                            break algorithm;
                        }
                    }
                }

            }
        }
    }

    // {'1', '1', '0', '1'} -> [1,3,4]
    private static List<Integer> getPositionsToChange(char [] positions) {
        List<Integer> positionsToChange = new ArrayList<>();
        for (int i = positions.length - 1; i >= 0; i--) {
            if (positions[i] == '1') {
                positionsToChange.add(positions.length - i);
            }
        }
        return positionsToChange;
    }

    // 12345, 0, [1, 3] -> 12040
    private static int changeNumberWithDigitInPositions(int number, int digit, List<Integer> positions) {
        char [] digits = String.valueOf(number).toCharArray();
        for (int i = 0; i < positions.size(); i++) {
            digits[digits.length - positions.get(i)] = Character.forDigit(digit, 10);
        }
        return Integer.valueOf(String.valueOf(digits));
    }
}
