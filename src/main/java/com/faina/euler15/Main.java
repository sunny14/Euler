package com.faina.euler15;

import java.math.BigInteger;
//TODO: use logging framework
//TODO: write dynamic programming solution + increase heap; the answer should be 137846528820
public class Main {


    private static final int SIZE = 20;

    public static void main( String [] args )   {


        Long pathsNumber = getPathsRecursive(0, 0);

        System.out.println(pathsNumber);

    }

    static Long getPathsRecursive(int x, int y)/**, int size) **/ {


        if (x == SIZE && y == SIZE)   {
            return 1L;
        }

        Long npaths = 0L, wpaths = 0L;
        if (x < SIZE)  {
            npaths = getPathsRecursive(x+1, y);
        }
        if (y < SIZE) {
            wpaths = getPathsRecursive(x, y+1);
        }

        return  npaths+wpaths;
    }

}
