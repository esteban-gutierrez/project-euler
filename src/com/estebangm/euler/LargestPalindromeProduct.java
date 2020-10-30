package com.estebangm.euler;

import java.util.ArrayList;
import java.util.List;

import static com.estebangm.euler.aux.AuxiliaryOperations.isPalindrome;

/**
 * ID 4
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * ANSWER: 906609
 */
public class LargestPalindromeProduct {

    public static void main (String [] args) {
        System.out.println(getLargestPalindromeProduct(100, 999));
    }

    private static long getLargestPalindromeProduct(int start, int end) {
        long highestPalindromeNumber = 0L;
        long product;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                product = i * j;
                if (isPalindrome(product) && (product > highestPalindromeNumber)) {
                    highestPalindromeNumber = product;
                }
            }
        }
        return highestPalindromeNumber;
    }
}
