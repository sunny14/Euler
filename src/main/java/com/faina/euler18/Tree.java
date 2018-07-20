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

            Integer [][] array = Arrays.stream(stream.toArray(String[]::new))
                    .map(Tree::convertFromLineToNumbers)
                    .toArray(Integer[][]::new);




            this.adjacencyList = createAjacencyList(getOneArray(array));

        } catch (Throwable e) {
            //TODO: logger
            e.printStackTrace();
        }

    }

    private Integer[] getOneArray(Integer[][] array) {

        int lastLineLength = array[array.length-1].length;
        Integer [] result = new Integer[array.length*lastLineLength];
        int resultArrayCounter = 0;

        for (int i=0; i<array.length; i++)  {
            for (int j=0; j<array[i].length;  j++)   {
                result[resultArrayCounter] = array[i][j];
                resultArrayCounter++;
            }
        }

        return result;
    }

    private List<Integer> [] createAjacencyList( Integer [] array) {

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

    private List <Integer> getRecord(Integer[] array, int i, int increment) {
        List <Integer> record = new ArrayList<>();
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
}



