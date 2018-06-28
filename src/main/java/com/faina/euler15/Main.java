package com.faina.euler15;

public class Main {


    private static final int SIZE = 20;

    public static void main( String [] args )   {


        int pathsNumber = getPathsRecursive(0, 0, SIZE);

        System.out.println(pathsNumber);

    }

    static int getPathsRecursive(int x, int y, int size) {


        if (x == size && y == size)   {
            return 1;
        }

        int npaths = 0, wpaths = 0;
        if (x < size)  {
            npaths = getPathsRecursive(x+1, y, size);
        }
        if (y < size) {
            wpaths = getPathsRecursive(x, y+1, size);
        }

        return  npaths+wpaths;
    }

}
