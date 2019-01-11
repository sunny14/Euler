package com.faina.euler18;

import com.faina.utils.MyIOUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class Tree {

    private List [] adjacencyList;


    public Tree(String filename) {



        File inputFile = MyIOUtils.getFileFromResources(filename);

        try (Stream<String> stream = Files.lines(Paths.get(inputFile.getAbsolutePath()))) {


            //TODO: turn the code into testable
            Integer [][] array = Arrays.stream(stream.toArray(String[]::new))
                    .map(Tree::convertFromLineToNumbers)
                    .toArray(Integer[][]::new);




            this.adjacencyList = createAjacencyList(getArrayOfNodes(array));

        } catch (Throwable e) {
            //TODO: logger
            e.printStackTrace();
        }

    }

    private Node[] getArrayOfNodes(Integer[][] array) {

        int resultArraySize = 0;
        for (int i=0; i<array.length; i++)  {
            for (int j=0; j<array[i].length;  j++)   {
                resultArraySize++;
            }
        }


        Node [] result = new Node[resultArraySize];
        int resultArrayCounter = 0;

        for (Integer i=0; i<array.length; i++)  {
            for (Integer j=0; j<array[i].length;  j++)   {
                result[resultArrayCounter] = new Node(i.toString()+"."+j, array[i][j]);
                resultArrayCounter++;
            }
        }

        return result;
    }

    private List<Integer> [] createAjacencyList( Node [] array) {

        List [] result = new ArrayList[array.length];

        int increment = 1;
        result[0] = getRecord(array, 0, increment);

            for (int i=1; i+increment+1< array.length; i++)    {

                if (i % 2 > 0) {
                    increment++;
                }

                result[i] = getRecord(array, i, increment);

            }


        return result;
    }

    private List <Node> getRecord(Node[] array, int i, int increment) {
        List <Node> record = new ArrayList<>();
        //add father node
        record.add(array[i]);

        //add sons
        record.add(array[i+increment]);
        record.add(array[i+increment+1]);

        return record;
    }






    private static Integer [] convertFromLineToNumbers(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("the string is " + s + ", exiting");
        }
        String[] storage = s.split(" ");

        Integer [] result = new Integer[storage.length];

        for (int i=0; i<storage.length; i++) {
            result[i] = Integer.parseInt(storage[i]);
        }

        return result;
    }

    private class Node  {
        String key;
        Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}



