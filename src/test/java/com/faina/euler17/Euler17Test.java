package com.faina.euler17;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

//FIXME: fix logging to debug level
public class Euler17Test {

    private static final Logger logger = LogManager.getLogger(Euler17Test.class.getName());

    @Test
    public void GeneralTest()  {
        int testInt = 4256;
        String expected = "FOURthousandTWOhundredANDfiftySIX";
        String res = new BritishNumbersParser(testInt).getStringValue();

        logger.error(res+" - "+expected);

        assertTrue(res.equalsIgnoreCase(expected));
    }

    @Test
    public void TeenTest()  {
        int testInt = 4213;
        String expected = "FOURthousandTWOhundredANDTHIRTEEN";
        String res = new BritishNumbersParser(testInt).getStringValue();

        logger.error(res+" - "+expected);

        assertTrue(res.equalsIgnoreCase(expected));
    }

    @Test
    public void ATest()  {
        int testInt = 1113;
        String expected = "onethousandonehundredANDTHIRTEEN";
        String res = new BritishNumbersParser(testInt).getStringValue();

        logger.error(res+" - "+expected);

        assertTrue(res.equalsIgnoreCase(expected));
    }

    @Test
    public void sumTest ()  {
        int sumOfLetters = 0;

        for (int i=1; i <= 5; i++) {
            String numberStr = new BritishNumbersParser(i).getStringValue();
            logger.error(numberStr);
            sumOfLetters += com.faina.euler17.Main.getNumberOfLetters(numberStr);
        }

        assertEquals(19, sumOfLetters);
    }

    @Test
    public void sumTest342()   {

        int testNum = 342;
        String res = new BritishNumbersParser(testNum).getStringValue();
        assertEquals(23, com.faina.euler17.Main.getNumberOfLetters(res).intValue());
    }

    @Test
    public void sumTest115()   {

        int testNum = 115;
        String res = new BritishNumbersParser(testNum).getStringValue();
        assertEquals(20, com.faina.euler17.Main.getNumberOfLetters(res).intValue());
    }
}
