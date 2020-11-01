package com.estebangm.euler;

import java.util.ArrayList;
import java.util.List;

import static com.estebangm.euler.aux.AuxiliaryOperations.getDividersOf;
import static com.estebangm.euler.aux.AuxiliaryOperations.getPrimeDividersOf;

/**
 * ID 69
 *
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine
 * the number of numbers less than n which are relatively prime to n.
 * For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 *
 *  n 	Relatively Prime 	φ(n) 	n/φ(n)
 *  2 	1 	                1 	    2
 *  3 	1,2 	            2 	    1.5
 *  4 	1,3 	            2 	    2
 *  5 	1,2,3,4 	        4 	    1.25
 *  6 	1,5 	            2 	    3
 *  7 	1,2,3,4,5,6 	    6 	    1.1666...
 *  8 	1,3,5,7 	        4 	    2
 *  9 	1,2,4,5,7,8 	    6 	    1.5
 *  10 	1,3,7,9 	        4 	    2.5
 *
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 *
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 *
 * ANSWER: 510510
 */
public class TotientMaximum {
    public static final Long GIVEN_NUMBER = 1000000L;

    public static void main (String [] args) {
        Float totientMaximum = 0f;
        Long nMaximum = 0l;
        for (long i = 2; i <= GIVEN_NUMBER; i++) {
            long eulersFunction = getOptimalSolutionOfEulersFunctionFor(i);
            float totient = (float) i/eulersFunction;
            //System.out.println(i + " | " + eulersFunction + "\t | " + totient);
            if (totient > totientMaximum) {
                totientMaximum = totient;
                nMaximum = i;
            }
        }
        System.out.println(nMaximum + " > phi(n)=" + totientMaximum);
    }

    private static long getOptimalSolutionOfEulersFunctionFor(Long n) {
        long totient = n;
        List<Long> primeDividers = getPrimeDividersOf(n);
        for (Long primeDivider : primeDividers) {
            totient = totient - (totient/primeDivider);
        }
        return totient;
    }

    // Only valid for n < 1000 (aprox)
    public static void naiveSolution() {
        Float totientMaximum = 0f;
        Long nMaximum = 0l;
        for (long i = 2; i <= GIVEN_NUMBER; i++) {
            List<Long> eulersTotient = getNaiveSolutionOfEulersTotientValuesFor(i);
            float totient = (float) i/eulersTotient.size();
            System.out.println(i + " | " + eulersTotient + "\t | " + totient);
            if (totient > totientMaximum) {
                totientMaximum = totient;
                nMaximum = i;
            }
        }
        System.out.println(nMaximum + " > phi(n)=" + totientMaximum);
    }

    private static List<Long> getNaiveSolutionOfEulersTotientValuesFor(Long n) {
        List<Long> eulersTotientValues = new ArrayList<>();
        List<Long> dividersOfN = getDividersOf(n);
        for (long i = 1; i < n; i++) {
            List<Long> dividers = getDividersExcludingOneOf(i);
            if (!haveAnyMatch(dividers, dividersOfN)) {
                eulersTotientValues.add(i);
            }
        }
        return eulersTotientValues;
    }

    private static List<Long> getDividersExcludingOneOf(long number) {
        List<Long> dividersExcludingOne = getDividersOf(number);
        dividersExcludingOne.remove(0);
        return dividersExcludingOne;
    }

    private static boolean haveAnyMatch(List<Long> firstList, List<Long> secondList) {
        for (Long dividerFirst : firstList) {
            if (secondList.contains(dividerFirst)) {
                return true;
            }
        }
        return false;
    }
}
