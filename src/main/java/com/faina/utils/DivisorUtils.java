package com.faina.euler12.utils;

import com.faina.euler13.Main;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DivisorUtils {


    /**
     * returns list of all divisors of thr given number; calculates divisors in a brute force manner
     * @param num
     * @return
     */
    public static List<BigInteger> getDivisorsPlain(BigInteger num)  {


        List<BigInteger> divisorsList = new ArrayList<>();

        for (BigInteger i = BigInteger.ONE; i.compareTo(num) <= 0 ; i = i.add(BigInteger.ONE)) {

            if (num.remainder(i) == BigInteger.ZERO) {
                divisorsList.add(i);
            }


        }


        return divisorsList;
    }


    /**
     * returns list of all divisors of thr given number; includes upgrades that should improve divisors' calculation
     * @param num
     * @return
     */
    public static List<BigInteger> getDivisorsUpgraded(BigInteger num) {

        List<BigInteger> divisorsList = new ArrayList<>();

        divisorsList.add(num);
        divisorsList.add(BigInteger.ONE);

        for (BigInteger i = BigInteger.TWO; i.compareTo(num.add(BigInteger.ONE).divide(BigInteger.TWO)) <= 0 ; i = i.add(BigInteger.ONE)) {


            if (num.remainder(i) == BigInteger.ZERO) {
                divisorsList.add(i);
            }
        }


        return divisorsList;

    }

    public static List<Integer> getProperDivisors(Integer num)    {
        List<Integer> divisors = new ArrayList<>();

        for (int i=1; i<=(num+1)/2; i++) {
            if (num % i == 0)   {
                divisors.add(i);
            }
        }

        return divisors;
    }
}
