package com.estebangm.euler;

import java.util.List;

import static com.estebangm.euler.aux.AuxiliaryOperations.getPrimeDividersOf;

/**
 * ID 3
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * ANSWER: 6857
 */
public class LargestPrimeFactor {
    public static final long GIVEN_NUMBER = 600851475143L;

    public static void main (String [] args) {
        List<Long> primeDividersOfGivenNumber = getPrimeDividersOf(GIVEN_NUMBER);
        if (primeDividersOfGivenNumber.isEmpty()) {
            System.out.println(GIVEN_NUMBER);
        } else {
            System.out.println(primeDividersOfGivenNumber.get(primeDividersOfGivenNumber.size()-1));
        }
    }
}
