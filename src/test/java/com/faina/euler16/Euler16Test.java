package com.faina.euler16;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class Euler16Test {

    @Test
    public void SmallValueTest()    {

        assertEquals(new BigInteger("154472377739119461"), com.faina.euler16.Main.getPositivePower(new BigInteger("13"), new BigInteger("21")));

    }
}
