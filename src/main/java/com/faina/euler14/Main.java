package com.faina.euler14;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static BigInteger THREE = new BigInteger("3");

    public static void main( String [] args )   {

        int currentCollatzSequenceLength = 1;
        int max = currentCollatzSequenceLength;
        Integer startingNumber = 1;

        for (Integer i=1; i < 1000000; i++) {
            currentCollatzSequenceLength = getCollatzSequence(i).size();
            if (currentCollatzSequenceLength > max) {
                max = currentCollatzSequenceLength;
                startingNumber = i;
            }
        }

        System.out.println(startingNumber);
    }


    static List<BigInteger> getCollatzSequence (Integer number)    {

        BigInteger num = BigInteger.valueOf(number);
        List<BigInteger> collatzSequence = new ArrayList<>();
        collatzSequence.add(num);

        while (num.compareTo(BigInteger.ONE) > 0) {
            num = getNextNumber(num);
            collatzSequence.add(num);
        };

        return collatzSequence;
    }


    private static BigInteger getNextNumber(BigInteger number) {
        //if number is even
        if (number.mod(BigInteger.TWO).compareTo(BigInteger.ZERO) == 0 )    {
            return number.divide(BigInteger.TWO);
        }

        //if the numver is odd
        return number.multiply(THREE).add(BigInteger.ONE);
    }

}
