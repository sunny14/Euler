package com.faina.euler13;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

       static BigInteger sum = BigInteger.ZERO;

       public static void main( String [] args )   {

              //Get file from resources folder
              ClassLoader classLoader = new Main().getClass().getClassLoader();
              File file = new File(classLoader.getResource("euler13").getFile());


              //TODO: try-with-resources
              try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {

                     BigInteger [] bigIntArray = Arrays.stream(stream.toArray(String[]::new))
                             .map(Main::convertFromStringToBigInteger)
                             .toArray(BigInteger[]::new);

                     for (BigInteger num: bigIntArray)  {
                            sum = sum.add(num);
                     }

                     System.out.println(sum.toString().substring(0, 10));

              } catch (IOException e) {
                     e.printStackTrace();
              }

              //get first 10 digits pf the sum

       }


       private static BigInteger convertFromStringToBigInteger(String unsorted) {
              return new BigInteger(unsorted);
       }

}
