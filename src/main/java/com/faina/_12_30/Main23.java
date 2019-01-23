package com.faina._12_30;


import com.google.common.annotations.VisibleForTesting;

import java.util.*;

import static com.faina.euler12.utils.DivisorUtils.getProperDivisors;

/**
 *

 A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 the smallest number that can be written as the sum of two abundant numbers is 24.
 By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number
 that cannot be expressed as the sum of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

 */

public class Main23 {

    private static int MAX = 28123;

    public static void main( String [] args )   {

        //get all abundant numbers up to MAX
        Set<Integer> abundantNums = getAllAbundantNums();

        //find all positive numbers which cannot be written as a sum of two abudant numbers
        List<Integer> nums = getAllNums(abundantNums);


        //sum these numbers
        Long sum = nums.stream().mapToLong(Integer::longValue).sum();

        System.out.println(sum);

    }

    public static Set<Integer> getAllAbundantNums() {

        Set<Integer> abudantNums = new HashSet<>();

        for (int i=12; i <= MAX; i++)   {
            if (isAbundant(i))  {
                abudantNums.add(i);
            }
        }

        return abudantNums;
    }

    public static boolean isAbundant(int i) {
        List<Integer> properDivisors = getProperDivisors(i);
        if (properDivisors.stream().mapToInt(Integer::intValue).sum() > i)  {
            return true;
        }

        return false;
    }

    public static List<Integer> getAllNums(Set<Integer> abudantNums) {

        List <Integer> result = new ArrayList<>();

        for (int i = 1; i< MAX; i++)    {

            boolean isSumOfAbundantNums = false;
            Iterator it = abudantNums.iterator();
            while (it.hasNext())    {

                Integer next = (Integer) it.next();
                if (abudantNums.contains(i-next))   {
                    isSumOfAbundantNums = true;
                    break;
                }
            }

            if (!isSumOfAbundantNums)    {
                result.add(i);
            }
        }

        return result;

    }

}
