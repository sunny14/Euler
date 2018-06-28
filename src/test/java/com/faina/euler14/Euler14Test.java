package com.faina.euler14;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler14Test {

    @Test
    public void SmallValueTest()    {
        assertEquals (10, com.faina.euler14.Main.getCollatzSequence(13).size());
    }
}
