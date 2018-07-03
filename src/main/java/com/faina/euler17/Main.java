package com.faina.euler17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TODO: fix logging to debug level, make debug logging work
public class Main {

    final static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main( String [] args )   {

        int sumOfLetters = 0;

        for (int i=1; i <= 1000; i++) {
            String numberStr = new BritishNumbersParser(i).getStringValue();
            logger.debug(numberStr);
            sumOfLetters += getNumberOfLetters(numberStr);
        }

        logger.debug("RESULT: "+sumOfLetters);


    }

    static Integer getNumberOfLetters(String exampleNuber) {
        return exampleNuber.length();
    }
}
