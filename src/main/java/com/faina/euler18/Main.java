package com.faina.euler18;

public class Main {

    public static void main( String [] args )   {

        //build the input tree
        Tree tree = new Tree("euler18");

        //trace the tree with BFS and find the max node value



        /**
         * find M max node value
         * find number of rows
         * find K the lenth of top-to-bottom path = number of rows
         * create list of all paths, starting from the tree root O and proceeding with BFS. calculate T the total path value in every stage
         *
         * while adding paths to the list, remove "the looser" paths that will not be the max path for sure.
         * comparing two paths A and B, we will remove path B if T(A)>=B+K*M
         */


        //

    }

}
