package com.faina.euler15;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Euler15Test {


    @Test
    public void SmallValueTest  ()  {
        assertEquals(6, com.faina.euler15.Main.getPathsRecursive(0, 0, 2));
    }
}
