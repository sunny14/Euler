package com.faina.test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

        //TODO: find out why BigInteger was slower than Integer
        //TODO: What is the difference between BigInteger and BigDecimal?
        int maxDividersNum = Integer.parseInt(args[0]);

        //generate triangle numbers
        int currentTriangleNum = getFirstTriangleNumWithDividers(maxDividersNum, true);

        System.out.println("RESULT: "+currentTriangleNum);



    }


    public static int getFirstTriangleNumWithDividers(int maxDividersNum, boolean useUpgradedMethod) {
        int divisorsNum = 0;
        int currentTriangleNum = 1;


        //TODO: use lambda
       /* DevisorsCalculator devisorsCalculator;
        if (useUpgradedMethod) {
            devisorsCalculator = currentTriangleNum -> getDivisorsUpgraded(currentTriangleNum);
        }
        else {
            devisorsCalculator = currentTriangleNum -> getDivisors(currentTriangleNum);
        }*/

        //TODO: start with 500!
        double startingPoint = Math.pow(2, maxDividersNum-1);

        for (int count=2; divisorsNum <= maxDividersNum; count++)  {

            if (currentTriangleNum > startingPoint) {

                if (useUpgradedMethod) {
                        divisorsNum = getDivisorsUpgraded(currentTriangleNum).size();
                } else {
                    divisorsNum = getDivisors(currentTriangleNum).size();
                }
            }

            if (divisorsNum <= maxDividersNum) {
                //TODO: move assert to tests
                assert (Integer.MAX_VALUE - currentTriangleNum >= count);
                currentTriangleNum += count;
            }
        }
        return currentTriangleNum;
    }


    //TODO: why ArrayList is faster than HashSet?
    public static List<Integer> getDivisorsUpgraded(Integer num) {

        List<Integer> divisorsList = new ArrayList<>();

        divisorsList.add(num);
        divisorsList.add(1);

        for (int i = 2; i <= (num+1)/2 ; i++) {


                if (num % i== 0) {
                    divisorsList.add(i);
                }
            }

        /*if (divisorsSet.size() > 400) {
            System.out.println(divisorsSet.size() + " : " + num);
        }*/
        //   }

        return divisorsList;

    }


    public static Set<Integer> getDivisors(int num)  {


        Set<Integer> divisorsSet = new HashSet<>();

            for (int i = 1; i <= num ; i++) {

                    if (num % i == 0) {
                        divisorsSet.add(i);
                    }


            }

            /*if (divisorsSet.size() > 300) {
                System.out.println(divisorsSet.size() + " : " + num);
            }*/

        return divisorsSet;
    }

    /*public static List<Integer> primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
    }
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .filter(n -> (n & 0X1) != 0)
                .allMatch(n -> x % n != 0);
    }*/

    /*private static boolean isPowerOfTwo(int number)    {
        return number > 0 && ((number & (number - 1)) == 0);
    }

    public static int fastModulo(int dividend, int divisor)
    {
        return dividend & (divisor - 1);
    }
*/

}
