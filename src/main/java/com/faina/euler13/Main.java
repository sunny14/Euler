package com.faina.euler13;

import com.faina.utils.MyIOUtils;

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
              File file = MyIOUtils.getFileFromResources("euler13");


              //try-with-resources
              try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {

                     BigInteger [] bigIntArray = Arrays.stream(stream.toArray(String[]::new))
                             .map(Main::convertFromStringToBigInteger)
                             .toArray(BigInteger[]::new);

                     for (BigInteger num: bigIntArray)  {
                            sum = sum.add(num);
                     }

                     //print first 10 digits of the sum
                     System.out.println(sum.toString().substring(0, 10));

              } catch (IOException e) {
                     e.printStackTrace();
              }



       }


       private static BigInteger convertFromStringToBigInteger(String unsorted) {
              return new BigInteger(unsorted);
       }

}
