package com.faina.test.euler12;


import com.faina.test.utils.DivisorUtils;

import java.math.BigInteger;


/**
 * CONCLUSIONS:
 *
 * 1. Some "improvements" make the code slower. Put a baseline before you start to improve
 * 2. I should know more about: collections implementation, bitwise operators,
 *      BigInteger implementation, int versus Integer, when we should use Lambda (and when we shouldn't)
 * 3. Use Git, label important code versions
 * 4. The efficiency is affected very much by a code from a loop inside another loop
 * 5. I should know more about cast issues
 * 6. Test program arguments
 * 7. Know more about ArrayList and HashSet implementations. Why adding to ArrayList is faster than adding to HashSet?
 * 8. Keep good logs, save the logs history at file
 */
public class Euler12 {


    //TODO: increase heap, test improvement
    public static void main ( String [] args )  {

        int maxDividersNum = 500;

        BigInteger currentTriangleNum = getTriangleNumber(maxDividersNum, true);

        System.out.println("RESULT: "+currentTriangleNum);

    }


    /**
     * get the first triangle number with over a given number of divisors
     * @param maxDivisorsNum
     * @param useUpgradedMethod
     * @return
     */
    public static BigInteger getTriangleNumber(int maxDivisorsNum, boolean useUpgradedMethod) {

        //local vars
        int divisorsNum = 0;
        BigInteger currentTriangleNum = BigInteger.ONE;

        //behavior parametrization
        DivisorsCalculator divisorsCalculator;
        if (useUpgradedMethod) {
            divisorsCalculator  = (BigInteger number)->{return DivisorUtils.getDivisorsUpgraded(number);};
        }
        else {
            divisorsCalculator  = (BigInteger number)->{return DivisorUtils.getDivisorsPlain(number);};
        }


        //repeat until the desired triangle number is found
        for (int count=2; divisorsNum <= maxDivisorsNum; count++)  {

            //calculate how much divisors the current triangle number has
            divisorsNum = divisorsCalculator.getDivisors(currentTriangleNum).size();

            //if current divisors' number is less that a desired divisors' number
            if (divisorsNum <= maxDivisorsNum) {
                //generate the next triangle number
                currentTriangleNum = currentTriangleNum.add(BigInteger.valueOf(count));
            }
        }

        return currentTriangleNum;
    }


}
