package com.faina.euler16;

import java.math.BigInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final BigInteger BASIS = BigInteger.TWO;
    final static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main( String [] args )   {

        BigInteger num  = getPowerOfTwo(new BigInteger("1000"));

        logger.info(getCypherSum(num));

    }

    private static BigInteger getPowerOfTwo(BigInteger power) {
        return getPositivePower(power, BASIS);
    }

    static BigInteger getPositivePower(BigInteger power, BigInteger base) {

        try {
            assert (power.compareTo(BigInteger.ZERO) >= 0);
        }catch (AssertionError error) {
            logger.error(error.getStackTrace());
        }

        if (power.equals(BigInteger.ZERO))  {
            return BigInteger.ONE;
        }

        if (power.equals(BigInteger.ONE))   {
            return base;
        }

        BigInteger result = BigInteger.ONE;

        boolean bit;

        //calculate with left-to-right technique
        for ( int i=power.bitLength()-1; i >= 0 ; i-- )   {

            bit = power.testBit(i);
            logger.debug("The current bit is {}", bit ? 1:0);

            result = result.pow(2);
            if (bit)   {
                result = result.multiply(base);
            }

        }

        return result;
    }

    private static long getCypherSum(BigInteger num) {

        long sum = 0L;

        for (Character ch: num.toString().toCharArray())  {
            sum+=(long)ch-48;
        }

        return sum;
    }
}
