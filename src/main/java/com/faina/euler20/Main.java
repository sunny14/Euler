package com.faina.euler20;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;

/**
 *

 n! means n × (n − 1) × ... × 3 × 2 × 1

 For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

 Find the sum of the digits in the number 100!

 */

public class Main {

    public static BigInteger factorialUsingGuava(int n) {
        return BigIntegerMath.factorial(n);
    }

    public static void main( String [] args )   {

        String factorial = factorialUsingGuava(100).toString();

        int sum = 0;
        for (int i=0; i+1< factorial.length(); i++)   {
            sum += Integer.parseInt(factorial.substring(i, i+1));
        }

        System.out.println("Сумма цифр "+sum);

    }
}
