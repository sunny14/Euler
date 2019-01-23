package com.faina.euler22;


import com.opencsv.CSVReader;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 *

 Using names.txt, a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order.
 Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 So, COLIN would obtain a score of 938 × 53 = 49714.

 What is the total of all the name scores in the file?

 */

public class Main {

    public static void main( String [] args ) throws IOException {


        //input names from file
        InputStream is = com.faina.euler22.Main.class.getClassLoader().getResourceAsStream("p022_names.txt");
        CSVReader reader = new CSVReader(new InputStreamReader(is));
        List<String[]> names = reader.readAll();

        //sort names
        TreeSet<String> treeSet = new TreeSet<>();
        for (String[] line: names)  {
            treeSet.addAll(Arrays.asList(line));
        }


        //get name scores
        int scoresSum = getScoresSum(treeSet);

        System.out.println(scoresSum);

    }

    private static int getScoresSum(TreeSet<String> treeSet) {
        int scoresSum = 0;
        int nameNumber = 1;
        Iterator it = treeSet.iterator();
        while (it.hasNext())    {
            String name = (String) it.next();
            scoresSum += getScore(name, nameNumber);


            //after
            nameNumber++;
        }
        return scoresSum;
    }

    private static int getScore(String name, int nameNumber) {

        String nameToLowerCase = name.toLowerCase();
        int wordWorth = 0;
        for (int i=0; i<nameToLowerCase.length(); i++) {

            wordWorth += (int)(nameToLowerCase.charAt(i))-96;
        }

        return wordWorth*nameNumber;
    }
}
