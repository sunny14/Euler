package com.faina._12_30;


import java.util.HashSet;
import java.util.Set;

import static com.faina.euler12.utils.DivisorUtils.getProperDivisors;

/**
 *

 Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.

 */
public class Main21 {

    public static void main( String [] args )   {

        Set<Integer> amicableNums = new HashSet<>();

        //find all amicable numbers under 10000
        for (int i=2; i< 10000; i++) {
            int sum = getProperDivisors(i).stream().mapToInt(Integer::intValue).sum();
            if (sum != i && getProperDivisors(sum).stream().mapToInt(Integer::intValue).sum() == i) {
                amicableNums.add(i);
                amicableNums.add(sum);
                System.out.println(sum + " - " + i);
            }
        }

        //sum amicable numbers
        System.out.println("Answer is "+amicableNums.stream().mapToInt(Integer::intValue).sum());

    }

}



